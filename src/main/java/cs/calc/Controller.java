package cs1302.calc;

import javafx.fxml.*;
import java.lang.Math;
import javafx.beans.value.*;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.awt.event.ActionListener;
import java.io.IOException;

public class Controller {


	@FXML
	private Label b1;

	@FXML
	private Label b2;

	@FXML
	private Label b3;

	@FXML
	private Label b4;

	@FXML
	private Label b5;

	@FXML
	private Label b6;

	@FXML
	private Label b7;

	@FXML
	private Label b8;

	@FXML
	private Label b9;

	@FXML
	private Label b10;

	@FXML
	private Label b11;

	@FXML
	private Label b12;

	@FXML
	private Label b13;

	@FXML
	private Label b14;

	@FXML
	private Label b15;

	@FXML
	private Label b16;

	@FXML
	private Label b18;

	@FXML
	private Label b17;

	@FXML
	private Label b19;

	@FXML
	private Label b20;

	@FXML
	private Label b21;

	@FXML
	private Label b22;

	@FXML
	private Label b23;

	@FXML
	private Label b24;

	@FXML
	private Label b25;

	@FXML
	private Label b26;

	@FXML
	private Label b28;

	@FXML
	private Label b27;

	@FXML
	private Label b29;

	@FXML
	private Label b30;

	@FXML
	private Label b31;

	@FXML
	private Label b32;

	private String textField = "";
	private boolean isRecursed = false;
	private int numResult = 0;
	private String ansText = "";

	@FXML
	private Button prodButton;

	@FXML
	private Button subButton;

	@FXML
	private Button bsButton;

	@FXML
	private Button resultButton;

	@FXML
	private Button shiftLButton;

	@FXML
	private Button expButton;

	@FXML
	private Button addButton;

	@FXML
	private Button quotButton;

	@FXML
	private Button shiftRButton;

	@FXML
	private Button emptyButton;

	@FXML
	private Button factorialButton;

	@FXML
	private Label result;

	@FXML
	private Button num0;

	@FXML
	private Button num1;

	@FXML
	private Button num2;

	@FXML
	private Button num3;

	@FXML
	private Button num4;

	@FXML
	private Button num5;

	@FXML
	private Button num6;

	@FXML
	private Button num7;

	@FXML
	private Button num8;

	@FXML
	private Button num9;

	@FXML
	private TextField equation;

	@FXML
	private Label pos1;

	@FXML
	private Label pos16;

	@FXML
	private Label pos32;

	@FXML
	private ToggleButton hideButton;

	@FXML
	private ToggleButton recurseButton;

	/**
	 * Sets up the shift left operation in RPN
	 * 
	 * @param event
	 */
	@FXML
	void shiftL(ActionEvent event){
		if(textField.equals("")){
			textField = ansText; //after finding result continue operation
			equation.setText(textField);
		}
		equation(shiftLButton);
	}

	/**
	 * Sets up the shift right operation in RPN
	 * 
	 * @param event
	 */
	@FXML
	void shiftR(ActionEvent event){

		if(textField.equals("")){
			textField = ansText;
			equation.setText(textField);
		}
		equation(shiftRButton);
	}

	/**
	 * Sets up the subtraction operation in RPN
	 * 
	 * @param event
	 */
	@FXML
	void subEQ(ActionEvent event) {

		if(textField.equals("")){
			textField = ansText;
			equation.setText(textField);
		}
		equation(subButton);
	}

	/**
	 * Sets up the subtraction operation in RPN
	 * 
	 * @param event
	 */
	@FXML
	void addEQ(ActionEvent event) {

		if(textField.equals("")){
			textField = ansText;
			equation.setText(textField);
		}
			
		equation(addButton);
	}

	/**
	 * Sets up the subtraction operation in RPN
	 * 
	 * @param event
	 */
	@FXML
	void productEQ(ActionEvent event) {

		if(textField.equals("")){
			textField = ansText;
			equation.setText(textField);
		}
		equation(prodButton);
	}

	/**
	 * Sets up the subtraction operation in RPN
	 * 
	 * @param event
	 */
	@FXML
	void divideEQ(ActionEvent event) {

		if(textField.equals("")){
			textField = ansText;
			equation.setText(textField);
		}
		equation(quotButton);
	}

	/**
	 * Where the math classes are created, will allow us to get a result from an equation based
	 * on string sequence in textfield
	 * 
	 * @param event
	 */
	@FXML
	void equalResult(ActionEvent event) {

		if(isRecursed){

			// string containing a mathematical expression represented in infix notation
			String expression = equation.getText();

			// convert the expression into an array by splitting it by white space
			String infix[] = expression.split(" ");

			// use the ReversePolishNotation class to get an array containing the expression
			// in post-fix notation
			String postfix[] = ReversePolishNotation.infixToPostfix(infix);

			// create an instance of your BasicMath class
			RecursiveMath recursiveMath = new RecursiveMath();

			// use the ReversePolishNotation class to evaluate the expression
			int result = ReversePolishNotation.evaluate(recursiveMath, postfix);
			numResult = result;
			ansText = numResult + "";
			this.result.setText(""+numResult);
			equation.setText("");
			textField = "";

		}

		if(!isRecursed){

			// string containing a mathematical expression represented in infix notation
			String expression = equation.getText();

			// convert the expression into an array by splitting it by white space
			String infix[] = expression.split(" ");

			// use the ReversePolishNotation class to get an array containing the expression
			// in post-fix notation
			String postfix[] = ReversePolishNotation.infixToPostfix(infix);

			// create an instance of your BasicMath class
			IterativeMath iterativeMath = new IterativeMath();

			// use the ReversePolishNotation class to evaluate the expression
			int result = ReversePolishNotation.evaluate(iterativeMath, postfix);
			numResult = result;
			ansText = numResult + "";
			this.result.setText(""+numResult);
			equation.setText("");
			textField = "";

		}

		String bit = "";
		int binbin = Integer.parseInt(result.getText());
		String bin = Integer.toBinaryString(binbin);
		Label[] labelArray = {b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25,b26,b27,b28,b29,b30,b31,b32};
		for (int i = bin.length()-1; i >= 0; i--){
			bit += ""+bin.charAt(i); //flipping converted result

		}

		bin = bit;
		bit = "";

		for (int i = 0; i < bin.length(); i++){
			bit = ""+bin.charAt(i); //setting the 0s to 1s
			labelArray[i].setText(bit);
		}

	}

	/**
	 * Sets up the exponential operation in RPN
	 * 
	 * @param event
	 */
	@FXML
	void exponential(ActionEvent event) {

		if(textField.equals("")){
			textField = ansText;
			equation.setText(textField);
		}
		equation(expButton);
	}

	/**
	 * Sets up the factorial operation in RPN
	 * 
	 * @param event
	 */
	@FXML
	void factorialNum(ActionEvent event) {

		if(textField.equals("")){
			textField = ansText;
			equation.setText(textField);
		}
		factorial(factorialButton);
	}

	/**
	 * Places 0 into textfield for RPN
	 * 
	 * @param event
	 */
	@FXML
	void handle0(ActionEvent event) {

		if(textField.equals("")){
			textField = "";
			ansText = "";
			equation.setText(textField);
			result.setText("");
		}
		buttonInBox(num0);
	}

	/**
	 * Places 1 into textfield for RPN
	 * 
	 * @param event
	 */
	@FXML
	void handle1(ActionEvent event) {

		if(textField.equals("")){
			textField = "";
			ansText = "";
			equation.setText(textField);
			result.setText("");
		}
		buttonInBox(num1);
	}

	/**
	 * Places 2 into textfield for RPN
	 * 
	 * @param event
	 */
	@FXML
	void handle2(ActionEvent event) {

		if(textField.equals("")){
			textField = "";
			ansText = "";
			equation.setText(textField);
			result.setText("");
		}
		buttonInBox(num2);
	}

	/**
	 * Places 3 into textfield for RPN
	 * 
	 * @param event
	 */
	@FXML
	void handle3(ActionEvent event) {

		if(textField.equals("")){
			textField = "";
			ansText = "";
			equation.setText(textField);
			result.setText("");
		}
		buttonInBox(num3);
	}

	/**
	 * Places 4 into textfield for RPN
	 * 
	 * @param event
	 */
	@FXML
	void handle4(ActionEvent event) {

		if(textField.equals("")){
			textField = "";
			ansText = "";
			equation.setText(textField);
			result.setText("");
		}
		buttonInBox(num4);
	}

	/**
	 * Places 5 into textfield for RPN
	 * 
	 * @param event
	 */
	@FXML
	void handle5(ActionEvent event) {

		if(textField.equals("")){
			textField = "";
			ansText = "";
			equation.setText(textField);
			result.setText("");
		}
		buttonInBox(num5);
	}

	/**
	 * Places 6 into textfield for RPN
	 * 
	 * @param event
	 */
	@FXML
	void handle6(ActionEvent event) {

		if(textField.equals("")){
			textField = "";
			ansText = "";
			equation.setText(textField);
			result.setText("");
		}
		buttonInBox(num6);
	}

	/**
	 * Places 7 into textfield for RPN
	 * 
	 * @param event
	 */
	@FXML
	void handle7(ActionEvent event) {

		if(textField.equals("")){
			textField = "";
			ansText = "";
			equation.setText(textField);
			result.setText("");
		}
		buttonInBox(num7);
	}

	/**
	 * Places 8 into textfield for RPN
	 * 
	 * @param event
	 */
	@FXML
	void handle8(ActionEvent event) {

		if(textField.equals("")){
			textField = "";
			ansText = "";
			equation.setText(textField);
			result.setText("");
		}
		buttonInBox(num8);
	}

	/**
	 * Places 9 into textfield for RPN
	 * 
	 * @param event
	 */
	@FXML
	void handle9(ActionEvent event) {

		if(textField.equals("")){
			textField = "";
			ansText = "";
			equation.setText(textField);
			result.setText("");
		}
		buttonInBox(num9);
	}

	/**
	 * Controls each 0 in the binary field, to be changed into a 1 and vice versa
	 * 
	 * @param event
	 */
	@FXML
	void b32handle(MouseEvent event) {

		if(b32.getText().equals("0")){
			b32.setText("1");
			numResult += Math.pow(2,31);
			result.setText(""+numResult);
		}

		else if(b32.getText().equals("1")){
			b32.setText("0");
			numResult -= Math.pow(2, 31);
			result.setText(""+numResult);
		}

	}

	/**
	 * Controls each 0 in the binary field, to be changed into a 1 and vice versa
	 * 
	 * @param event
	 */
	@FXML
	void b31handle(MouseEvent event) {

		if(b31.getText().equals("0")){
			b31.setText("1");
			numResult += Math.pow(2,30);
			result.setText(""+numResult);
		}

		else if(b31.getText().equals("1")){
			b31.setText("0");
			numResult -= Math.pow(2, 30);
			result.setText(""+numResult);
		}
	}

	/**
	 * Controls each 0 in the binary field, to be changed into a 1 and vice versa
	 * 
	 * @param event
	 */
	@FXML
	void b30handle(MouseEvent event) {

		if(b30.getText().equals("0")){
			b30.setText("1");
			numResult += Math.pow(2,29);
			result.setText(""+numResult);
		}

		else if(b30.getText().equals("1")){
			b30.setText("0");
			numResult -= Math.pow(2, 29);
			result.setText(""+numResult);
		}
	}

	/**
	 * Controls each 0 in the binary field, to be changed into a 1 and vice versa
	 * 
	 * @param event
	 */
	@FXML
	void b29handle(MouseEvent event) {

		if(b29.getText().equals("0")){
			b29.setText("1");
			numResult += Math.pow(2,28);
			result.setText(""+numResult);
		}

		else if(b29.getText().equals("1")){
			b29.setText("0");
			numResult -= Math.pow(2, 28);
			result.setText(""+numResult);
		}
	}

	/**
	 * Controls each 0 in the binary field, to be changed into a 1 and vice versa
	 * 
	 * @param event
	 */
	@FXML
	void b28handle(MouseEvent event) {

		if(b28.getText().equals("0")){
			b28.setText("1");
			numResult += Math.pow(2,28);
			result.setText(""+numResult);
		}

		else if(b28.getText().equals("1")){
			b28.setText("0");
			numResult -= Math.pow(2, 27);
			result.setText(""+numResult);
		}
	}

	/**
	 * Controls each 0 in the binary field, to be changed into a 1 and vice versa
	 * 
	 * @param event
	 */
	@FXML
	void b27handle(MouseEvent event) {

		if(b27.getText().equals("0")){
			b27.setText("1");
			numResult += Math.pow(2,26);
			result.setText(""+numResult);
		}

		else if(b27.getText().equals("1")){
			b27.setText("0");
			numResult -= Math.pow(2, 26);
			result.setText(""+numResult);
		}
	}

	/**
	 * Controls each 0 in the binary field, to be changed into a 1 and vice versa
	 * 
	 * @param event
	 */
	@FXML
	void b26handle(MouseEvent event) {

		if(b26.getText().equals("0")){
			b26.setText("1");
			numResult += Math.pow(2,25);
			result.setText(""+numResult);
		}

		else if(b26.getText().equals("1")){
			b26.setText("0");
			numResult -= Math.pow(2, 25);
			result.setText(""+numResult);
		}
	}

	/**
	 * Controls each 0 in the binary field, to be changed into a 1 and vice versa
	 * 
	 * @param event
	 */
	@FXML
	void b25handle(MouseEvent event) {

		if(b25.getText().equals("0")){
			b25.setText("1");
			numResult += Math.pow(2,24);
			result.setText(""+numResult);
		}

		else if(b25.getText().equals("1")){
			b25.setText("0");
			numResult -= Math.pow(2, 24);
			result.setText(""+numResult);
		}
	}

	/**
	 * Controls each 0 in the binary field, to be changed into a 1 and vice versa
	 * 
	 * @param event
	 */
	@FXML
	void b24handle(MouseEvent event) {
		if(b24.getText().equals("0")){
			b24.setText("1");
			numResult += Math.pow(2,23);
			result.setText(""+numResult);
		}

		else if(b24.getText().equals("1")){
			b24.setText("0");
			numResult -= Math.pow(2, 23);
			result.setText(""+numResult);
		}
	}

	/**
	 * Controls each 0 in the binary field, to be changed into a 1 and vice versa
	 * 
	 * @param event
	 */
	@FXML
	void b23handle(MouseEvent event) {
		if(b23.getText().equals("0")){
			b23.setText("1");
			numResult += Math.pow(2,22);
			result.setText(""+numResult);
		}

		else if(b23.getText().equals("1")){
			b23.setText("0");
			numResult -= Math.pow(2, 22);
			result.setText(""+numResult);
		}
	}

	/**
	 * Controls each 0 in the binary field, to be changed into a 1 and vice versa
	 * 
	 * @param event
	 */
	@FXML
	void b22handle(MouseEvent event) {
		if(b22.getText().equals("0")){
			b22.setText("1");
			numResult += Math.pow(2,21);
			result.setText(""+numResult);
		}

		else if(b22.getText().equals("1")){
			b22.setText("0");
			numResult -= Math.pow(2, 21);
			result.setText(""+numResult);
		}
	}

	/**
	 * Controls each 0 in the binary field, to be changed into a 1 and vice versa
	 * 
	 * @param event
	 */
	@FXML
	void b21handle(MouseEvent event) {
		if(b21.getText().equals("0")){
			b21.setText("1");
			numResult += Math.pow(2,20);
			result.setText(""+numResult);
		}

		else if(b21.getText().equals("1")){
			b21.setText("0");
			numResult -= Math.pow(2, 20);
			result.setText(""+numResult);
		}
	}

	/**
	 * Controls each 0 in the binary field, to be changed into a 1 and vice versa
	 * 
	 * @param event
	 */
	@FXML
	void b20handle(MouseEvent event) {
		if(b20.getText().equals("0")){
			b20.setText("1");
			numResult += Math.pow(2,19);
			result.setText(""+numResult);
		}

		else if(b20.getText().equals("1")){
			b20.setText("0");
			numResult -= Math.pow(2, 19);
			result.setText(""+numResult);
		}
	}

	/**
	 * Controls each 0 in the binary field, to be changed into a 1 and vice versa
	 * 
	 * @param event
	 */
	@FXML
	void b19handle(MouseEvent event) {
		if(b19.getText().equals("0")){
			b19.setText("1");
			numResult += Math.pow(2,18);
			result.setText(""+numResult);
		}

		else if(b19.getText().equals("1")){
			b19.setText("0");
			numResult -= Math.pow(2, 18);
			result.setText(""+numResult);
		}
	}

	/**
	 * Controls each 0 in the binary field, to be changed into a 1 and vice versa
	 * 
	 * @param event
	 */
	@FXML
	void b18handle(MouseEvent event) {
		if(b18.getText().equals("0")){
			b1.setText("1");
			numResult += Math.pow(2,17);
			result.setText(""+numResult);
		}

		else if(b18.getText().equals("1")){
			b18.setText("0");
			numResult -= Math.pow(2, 17);
			result.setText(""+numResult);
		}
	}

	/**
	 * Controls each 0 in the binary field, to be changed into a 1 and vice versa
	 * 
	 * @param event
	 */
	@FXML
	void b17handle(MouseEvent event) {
		if(b17.getText().equals("0")){
			b17.setText("1");
			numResult += Math.pow(2,16);
			result.setText(""+numResult);
		}

		else if(b17.getText().equals("1")){
			b17.setText("0");
			numResult -= Math.pow(2, 16);
			result.setText(""+numResult);
		}
	}

	/**
	 * Controls each 0 in the binary field, to be changed into a 1 and vice versa
	 * 
	 * @param event
	 */
	@FXML
	void b16handle(MouseEvent event) {
		if(b16.getText().equals("0")){
			b1.setText("1");
			numResult += Math.pow(2,15);
			result.setText(""+numResult);
		}

		else if(b16.getText().equals("1")){
			b16.setText("0");
			numResult -= Math.pow(2, 15);
			result.setText(""+numResult);
		}
	}

	/**
	 * Controls each 0 in the binary field, to be changed into a 1 and vice versa
	 * 
	 * @param event
	 */
	@FXML
	void b15handle(MouseEvent event) {
		if(b15.getText().equals("0")){
			b1.setText("1");
			numResult += Math.pow(2,13);
			result.setText(""+numResult);
		}

		else if(b15.getText().equals("1")){
			b15.setText("0");
			numResult -= Math.pow(2, 14);
			result.setText(""+numResult);
		}
	}

	/**
	 * Controls each 0 in the binary field, to be changed into a 1 and vice versa
	 * 
	 * @param event
	 */
	@FXML
	void b14handle(MouseEvent event) {
		if(b14.getText().equals("0")){
			b14.setText("1");
			numResult += Math.pow(2,13);
			result.setText(""+numResult);
		}

		else if(b14.getText().equals("1")){
			b14.setText("0");
			numResult -= Math.pow(2, 13);
			result.setText(""+numResult);
		}
	}

	/**
	 * Controls each 0 in the binary field, to be changed into a 1 and vice versa
	 * 
	 * @param event
	 */
	@FXML
	void b13handle(MouseEvent event) {
		if(b13.getText().equals("0")){
			b13.setText("1");
			numResult += Math.pow(2,12);
			result.setText(""+numResult);
		}

		else if(b13.getText().equals("1")){
			b13.setText("0");
			numResult -= Math.pow(2, 12);
			result.setText(""+numResult);
		}
	}

	/**
	 * Controls each 0 in the binary field, to be changed into a 1 and vice versa
	 * 
	 * @param event
	 */
	@FXML
	void b12handle(MouseEvent event) {
		if(b12.getText().equals("0")){
			b12.setText("1");
			numResult += Math.pow(2, 11);
			result.setText(""+numResult);
		}

		else if(b12.getText().equals("1")){
			b12.setText("0");
			numResult -= Math.pow(2, 11);
			result.setText(""+numResult);
		}
	}

	/**
	 * Controls each 0 in the binary field, to be changed into a 1 and vice versa
	 * 
	 * @param event
	 */
	@FXML
	void b11handle(MouseEvent event) {
		if(b11.getText().equals("0")){
			b11.setText("1");
			numResult += Math.pow(2,10);
			result.setText(""+numResult);
		}

		else if(b11.getText().equals("1")){
			b11.setText("0");
			numResult -= Math.pow(2, 10);
			result.setText(""+numResult);
		}
	}

	/**
	 * Controls each 0 in the binary field, to be changed into a 1 and vice versa
	 * 
	 * @param event
	 */
	@FXML
	void b10handle(MouseEvent event) {
		if(b10.getText().equals("0")){
			b10.setText("1");
			numResult += Math.pow(2,9);
			result.setText(""+numResult);
		}

		else if(b10.getText().equals("1")){
			b10.setText("0");
			numResult -= Math.pow(2, 9);
			result.setText(""+numResult);
		}
	}

	/**
	 * Controls each 0 in the binary field, to be changed into a 1 and vice versa
	 * 
	 * @param event
	 */
	@FXML
	void b9handle(MouseEvent event) {
		if(b9.getText().equals("0")){
			b9.setText("1");
			numResult += Math.pow(2,8);
			result.setText(""+numResult);
		}

		else if(b1.getText().equals("1")){
			b9.setText("0");
			numResult -= Math.pow(2, 8);
			result.setText(""+numResult);
		}
	}

	/**
	 * Controls each 0 in the binary field, to be changed into a 1 and vice versa
	 * 
	 * @param event
	 */
	@FXML
	void b8handle(MouseEvent event) {
		if(b8.getText().equals("0")){
			b8.setText("1");
			numResult += Math.pow(2,7);
			result.setText(""+numResult);
		}

		else if(b8.getText().equals("1")){
			b8.setText("0");
			numResult -= Math.pow(2, 7);
			result.setText(""+numResult);
		}
	}

	/**
	 * Controls each 0 in the binary field, to be changed into a 1 and vice versa
	 * 
	 * @param event
	 */
	@FXML
	void b7handle(MouseEvent event) {
		if(b7.getText().equals("0")){
			b7.setText("1");
			numResult += Math.pow(2,6);
			result.setText(""+numResult);
		}

		else if(b7.getText().equals("1")){
			b7.setText("0");
			numResult -= Math.pow(2, 6);
			result.setText(""+numResult);
		}
	}

	/**
	 * Controls each 0 in the binary field, to be changed into a 1 and vice versa
	 * 
	 * @param event
	 */
	@FXML
	void b6handle(MouseEvent event) {
		if(b6.getText().equals("0")){
			b6.setText("1");
			numResult += Math.pow(2,5);
			result.setText(""+numResult);
		}

		else if(b6.getText().equals("1")){
			b6.setText("0");
			numResult -= Math.pow(2, 5);
			result.setText(""+numResult);
		}
	}

	/**
	 * Controls each 0 in the binary field, to be changed into a 1 and vice versa
	 * 
	 * @param event
	 */
	@FXML
	void b5handle(MouseEvent event) {
		if(b5.getText().equals("0")){
			b5.setText("1");
			numResult += Math.pow(2,4);
			result.setText(""+numResult);
		}

		else if(b5.getText().equals("1")){
			b5.setText("0");
			numResult -= Math.pow(2, 4);
			result.setText(""+numResult);
		}
	}

	/**
	 * Controls each 0 in the binary field, to be changed into a 1 and vice versa
	 * 
	 * @param event
	 */
	@FXML
	void b4handle(MouseEvent event) {
		if(b4.getText().equals("0")){
			b4.setText("1");
			numResult += Math.pow(2,3);
			result.setText(""+numResult);
		}

		else if(b4.getText().equals("1")){
			b4.setText("0");
			numResult -= Math.pow(2, 3);
			result.setText(""+numResult);
		}
	}

	/**
	 * Controls each 0 in the binary field, to be changed into a 1 and vice versa
	 * 
	 * @param event
	 */
	@FXML
	void b3handle(MouseEvent event) {
		if(b3.getText().equals("0")){
			b3.setText("1");
			numResult += Math.pow(2,2);
			result.setText(""+numResult);
		}

		else if(b3.getText().equals("1")){
			b3.setText("0");
			numResult -= Math.pow(2, 2);
			result.setText(""+numResult);
		}
	}

	/**
	 * Controls each 0 in the binary field, to be changed into a 1 and vice versa
	 * 
	 * @param event
	 */
	@FXML
	void b2handle(MouseEvent event) {
		if(b2.getText().equals("0")){
			b2.setText("1");
			numResult += Math.pow(2,1);
			result.setText(""+numResult);
		}

		else if(b2.getText().equals("1")){
			b2.setText("0");
			numResult -= Math.pow(2, 1);
			result.setText(""+numResult);
		}
	}

	/**
	 * Controls each 0 in the binary field, to be changed into a 1 and vice versa
	 * 
	 * @param event
	 */
	@FXML
	void b1handle(MouseEvent event) {
		
			if(b1.getText().equals("0")){
				b1.setText("1");
				numResult += Math.pow(2,0);
				result.setText(""+numResult);
			}

			else if(b1.getText().equals("1")){
				b1.setText("0");
				numResult -= Math.pow(2, 0);
				result.setText(""+numResult);
			}
	}

	/**
	 * Controls whether or not the binary field will be visible
	 * 
	 * @param event
	 */
	@FXML
	void binary(ActionEvent event) {

		Label[] labelArray = {b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25,b26,b27,b28,b29,b30,b31,b32};

		if(hideButton.isSelected()){
			for (int i = 0; i < labelArray.length; i++)
				labelArray[i].setVisible(false);

			pos1.setVisible(false);
			pos16.setVisible(false);
			pos32.setVisible(false);
			hideButton.setText("Show Binary");
		}

		else if(!hideButton.isSelected()){
			for (int i = 0; i< labelArray.length; i++)
				labelArray[i].setVisible(true);

			pos1.setVisible(true);
			pos16.setVisible(true);
			pos32.setVisible(true);
			hideButton.setText("Hide Binary");
		}

	}

	/**
	 * Determines toggle for Iteration and Recursion
	 * 
	 * @param event
	 */
	@FXML
	void recurse(ActionEvent event) {

		if(!isRecursed){
			recurseButton.setSelected(true);
			recurseButton.setText("Use Iteration");
			isRecursed = true;

		}
		else if(isRecursed){
			recurseButton.setSelected(false);
			recurseButton.setText("Use Recursion");
			isRecursed = false;
		}
	}

	/**
	 * Deletes most recent number/operation in field
	 * 
	 * @param event
	 */
	@FXML
	void backspace(ActionEvent event){

		textField = equation.getText();
		textField = textField.substring(0, equation.getText().length()-1);
		equation.setText(textField);
	}

	/**
	 * Resets all values
	 * 
	 * @param event
	 */
	@FXML
	void empty(ActionEvent event){

		ansText = "";
		result.setText("");
		textField = "";
		numResult = 0;
		equation.setText("");
	}

	/**
	 * Sets a commomn method for numbers when they are pressed (ie distance between other numbers)
	 * @param pressed
	 */
	private void buttonInBox(Button pressed){
		
		ansText = ""+numResult;
		textField += pressed.getText();
		equation.setText(textField);	
	}

	/**
	 * Sets a commomn method for operations when they are pressed (ie distance between other numbers and operations)
	 * @param pressed
	 */
	private void equation(Button pressed){
		ansText = ""+numResult;
		textField += " " + pressed.getText() + " ";
		equation.setText(textField);	
	}

	/**
	 * Different from numbers nad operations. Treats spacing with one less space than operation.
	 * @param pressed
	 */
	private void factorial(Button pressed){
		ansText = ""+numResult;
		textField += " " + pressed.getText();
		equation.setText(textField);	
	}			

}



