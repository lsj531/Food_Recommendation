import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleUnaryOperator;
public class Ex1 {

	private static final double epsilon = Double.MIN_VALUE;
	private static double mu[];
	private static double sigma[];

	public static void main(String[] args) {
		new Ex1().run();
	}

	private void run() {	
		List<Attribute> dataX = nomalization(loadDataX());

		List<Double> dataY = loadDataY();

		double alpha = 0.01;
		int maxIterations = 10000;
		
		List<Double> finalTheta = singleVarGradientDescent(dataX,dataY,initialTheta(), alpha, maxIterations);
		//System.out.printf("theta0 = %f, theta1 = %f", finalTheta.getX(), finalTheta.getY());
		
		for(int i=0 ; i<finalTheta.size() ; i++) {
			System.out.printf("%d theta = %.5f ",i , finalTheta.get(i));
			System.out.println();
		}
		
		System.out.println("cost : "+hypothesis(dataX, dataY, finalTheta));


		
		
		/*
		 * 확인작업
		 * 입력데이터와 같은 값
		 */
		double r1=0,r2=0,r3=0,r4=0,r5=0;

		double[] in1 = {1,1,1,1,0,1,1,0,0};
		double[] in2 = {1,2,1,1,0,1,1,0,0};
		double[] in3 = {1,3,1,1,0,1,1,0,0};
		double[] in4 = {1,1,1,0.5,0,0,1,1,1};
		double[] in5 = {1,0,0,0,1,0,0,0,0};
		
		for(int i=1 ; i<in1.length;i++) {
			in1[i] = (in1[i]-mu[i])/sigma[i];
			in2[i] = (in2[i]-mu[i])/sigma[i];
			in3[i] = (in3[i]-mu[i])/sigma[i];
			in4[i] = (in4[i]-mu[i])/sigma[i];
			in5[i] = (in5[i]-mu[i])/sigma[i];
		}
		for(int i=0 ; i<finalTheta.size() ; i++) {
			r1 += finalTheta.get(i)*in1[i];
			r2 += finalTheta.get(i)*in2[i];
			r3 += finalTheta.get(i)*in3[i];
			r4 += finalTheta.get(i)*in4[i];
			r5 += finalTheta.get(i)*in5[i];
		}		
		System.out.println(r1+ " "+ r2 + " "+ r3+ " "+ r4+ " "+ r5);
		
		
	}
	private List<Attribute> nomalization(List<Attribute> dataX) {

		int attribute_num = dataX.get(0).getAttribute().size();
		mu = new double[attribute_num];
		sigma = new double[attribute_num];
		double sum_tmp =0.0;

		List<Attribute> new_dataX = new ArrayList();
		int num = dataX.size()*dataX.get(0).getAttribute().size();
		int input_num = dataX.size();
		for(int i=0 ; i<dataX.get(0).getAttribute().size() ; i++) {
			sum_tmp = 0.0;
			for(int j=0 ;j<dataX.size() ; j++) {
				sum_tmp += dataX.get(j).getAttribute().get(i);
			}
			mu[i] = sum_tmp / input_num;
		}
		for(int i=0 ; i<dataX.get(0).getAttribute().size() ; i++) {
			sum_tmp = 0.0;
			for(int j=0 ;j<dataX.size() ; j++) {
				sum_tmp += Math.pow((dataX.get(j).getAttribute().get(i)-mu[i]), 2);
			}
			sigma[i] = sum_tmp / (input_num-1);
			sigma[i] = Math.sqrt(sigma[i]);
		}
		for(int i=0 ; i<dataX.size() ; i++) {
			ArrayList<Double> tmp = new ArrayList<>();
			for(int j=0 ;j<dataX.get(i).getAttribute().size() ; j++) {
				tmp.add((dataX.get(i).getAttribute().get(j) - mu[j]) / sigma[j]);
			}
			new_dataX.add(new Attribute().setX0(1.0)
					.setX1(tmp.get(1))
					.setX2(tmp.get(2))
					.setX3(tmp.get(3))
					.setX4(tmp.get(4))
					.setX5(tmp.get(5))
					.setX6(tmp.get(6))
					.setX7(tmp.get(7))
					.setX8(tmp.get(8)));
		}	
		//		for(int i=0 ; i<9;i++) {
		//
		//			System.out.printf("%.3f    ",mu[i]);
		//		}
		//		System.out.println();
		//		for(int i=0 ; i<9;i++) {
		//
		//			System.out.printf("%.3f    ",sigma[i]);
		//		}
//		for(int i=0 ; i<dataX.size() ; i++) {
//
//			for(int j=0 ;j<dataX.get(i).getAttribute().size() ; j++) {
//				System.out.print(new_dataX.get(i).getAttribute().get(j) + " ");
//			}
//			System.out.println();
//		}
		return new_dataX;
	}
	private List<Double> initialTheta() {
		List<Double> list = new ArrayList<Double>();
		list.add(1.0);
		for(int i=0; i<8 ; i++) {
			list.add(0.0);
		}
		return list;
	}

	private List<Double> singleVarGradientDescent(List<Attribute> dataX,List<Double> dataY
			,List<Double> theta, double alpha, int maxIterations) {

		int m = dataX.size();
		for (int i = 0 ; i < maxIterations; i++) {

			ArrayList<Double> theta_tmp = new ArrayList();
			ArrayList<Double> htheta = new ArrayList();

			for(int j=0 ; j<dataX.size();j++) {
				double tmp = 0.0;
				for(int k=0 ; k<dataX.get(j).getAttribute().size(); k++) {

					tmp += dataX.get(j).getAttribute().get(k)*theta.get(k);
				}
				htheta.add(tmp);
			}

			for(int j=0 ; j<9;j++) {
				theta_tmp.add(theta.get(j)-alpha/m*gradientSub(htheta,dataY,dataX,j));
			}
			for(int j=0 ; j<9;j++) {
				theta.set(j, theta_tmp.get(j));
			}
			hypothesis(dataX,dataY,theta);
		}
		return theta;
	}
	private double gradientSub(ArrayList<Double> htheta, List<Double> dataY,List<Attribute> dataX,int idx) {
		double sum= 0.0;
		for(int i=0 ; i<dataY.size();i++) {
			sum += (htheta.get(i) - dataY.get(i)) * dataX.get(i).getAttribute().get(idx);
		}
		return sum;
	}


	private double hypothesis(List<Attribute> x, List<Double> y, List<Double> theta) {
		double j = 0.0;
		double tmp = 0.0;
		for(int i=0 ;i<x.size(); i++) {
			tmp =0.0;
			for(int k=0 ; k<x.get(i).getAttribute().size();k++) {
				tmp += (x.get(i).getAttribute().get(k)*theta.get(k));
			}
			j+=(tmp-y.get(i))*(tmp-y.get(i));

		}
		j = j/(2*x.size());
		return j;
	}



	// 데이터를 입력과 가져오는걸 따로 만들어야 함 여기서는 생략..
	private List<Attribute> loadDataX() {
		List<Attribute> data = new ArrayList<>();
		
		data.add(new Attribute().setX1(1).setX2(1).setX3(1).setX4(0).setX5(1).setX6(1).setX7(0).setX8(0));
		data.add(new Attribute().setX1(2).setX2(1).setX3(1).setX4(0).setX5(1).setX6(1).setX7(0).setX8(0));
		data.add(new Attribute().setX1(3).setX2(1).setX3(1).setX4(0).setX5(1).setX6(1).setX7(0).setX8(0));
		data.add(new Attribute().setX1(1).setX2(1).setX3(0.5).setX4(0).setX5(0).setX6(1).setX7(1).setX8(1));
		data.add(new Attribute().setX1(0).setX2(0).setX3(0).setX4(1).setX5(0).setX6(0).setX7(0).setX8(0));

		return data;
	}
	private List<Double> loadDataY() {
		List<Double> data = new ArrayList<>();
		data.add(1.0);
		data.add(1.0);
		data.add(1.0);
		data.add(2.0);
		data.add(3.0);

		return data;
	}
}










