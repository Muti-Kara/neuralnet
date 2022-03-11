import java.io.IOException;

import algebra.NetworkParameters;
import network.NeuralNetwork;
import preproccess.images.InputImage;
import preproccess.parameters.Reader;
import training.CNNTrainer;


/**
* Main
*/
public class Main {
	
	public static void main(String[] args) throws IOException {
		
		NetworkParameters.addConvolutionalLayer(2, 5, 2);
		NetworkParameters.addConvolutionalLayer(2, 3, 2);
		NetworkParameters.addFullyConnectedLayer(256);
		NetworkParameters.addFullyConnectedLayer(26);
		
		
		NetworkParameters.setEpoch(200);
		NetworkParameters.setStochastic(10);
		
		NetworkParameters.setCnnEpoch(5);
		NetworkParameters.setCnnGeneration(20);
		
		NetworkParameters.setImageSize(37);
		
		NetworkParameters.setLearningRate(0.3);
		NetworkParameters.setMomentumFactor(0.01);
		NetworkParameters.setCnnLearningRate(0.05);
		
		NetworkParameters.setKernelRandomization(0.1);
		NetworkParameters.setRandomization(0.01);
		
		InputImage dataImg = new InputImage();
		
		CNNTrainer trainer = new CNNTrainer(dataImg);
		trainer.train();
		
		// NeuralNetwork network = Reader.readNN();
		// for(int index = 0; index < NetworkParameters.testSize; index++){
		//  	String str = network.classify( dataImg.getTests(index) );
		//  	System.out.println(dataImg.getExpected(index) + str);
		// }
		
	}
	
}



