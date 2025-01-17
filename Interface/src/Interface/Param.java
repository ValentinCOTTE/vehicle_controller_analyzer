package Interface;
import javax.swing.JPanel;

import Principal.Application;
import Principal.Car_set;
import Principal.Param_set;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import Action_listener.Cars_settings;
import Action_listener.Define_marking;
import Action_listener.Edit_code;
import Action_listener.Edit_queries;
import Action_listener.Finish;
import Action_listener.Load_settings;

import javax.swing.JLabel;

public class Param extends JPanel {

	Application app;
	private JTextField txtS;
	private JTextField txtL;
	private JLabel lblL;
	private JTextField txtscale;
	private JLabel lblScale;
	private JTextField txtR;
	private JLabel lblR;
	private JTextField txtV_min;
	private JLabel lblVmin;
	private JTextField txtGranA;
	private JLabel lblGranA;
	private JTextField txtW;
	private JTextField txtNormX;
	private JLabel lblMarking;
	private JButton btnDefine;
	private JTextField txtnb_lane;
	private JLabel lblNblane;
	private JTextField txtend_junction;
	private JLabel lblEndjunction;
	private JTextField txtbegin_junction;
	private JLabel lblBeginjunction;
	private JTextField txtnb_car;
	private JLabel lblnb_car;
	private JTextField txtsafety_length;
	private JLabel lblSafetylength;
	private JTextField txtsafety_width;
	private JLabel lblSafetywidth;
	private JTextField txttraj_length;
	private JLabel lbltraj_length;
	private JTextField txtdelay_step;
	private JLabel lblDelayStep;
	private JTextField txtmax_delay;
	private JLabel lblMaxdelay;
	private JButton btnCarsSettings;
	private JButton btnEditCode;
	private JLabel lblDEVELOPPEROPTION;
	private JLabel lblNewLabel;
	private JButton btnFinish;

	private JButton btnEditQueries;
	private JButton btnLoadSettings;


	int scale;
	int S;
	int L;
	int R;
	int V_min;
	int GranA;
	int W;
	int NormX; //( >= (GranA*S/scale)/2 )
	int nb_lane; //( >= 2 )
	int end_junction; //( <= L )
	int begin_junction; //( <= end_junction )
	ArrayList<Integer> marking=new ArrayList<Integer>(); //[nb_lane + 1] ( marking[i] <= marking[i-1] ) to build as a list {posY, ... , posY}
	int nb_car; //( >= 2 )
	int safety_length;
	int safety_width;
	int traj_length;
	int delay_step;
	int max_delay; //(integer multiple of delay_step)
	ArrayList<Car_set> Car_list=new ArrayList<Car_set>();

	int navigation_points_max;
	int V_max;
	int A_min;
	int A_max;


	public Param(Application a,Param_set set) {
		this.load(set);

		this.app=a;
		this.app.setTitle("Parameters");

		setBounds(100, 100, 450, 630);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		btnLoadSettings = new JButton("LOAD SETTINGS");
		btnLoadSettings.addActionListener(new Load_settings(this));
		GridBagConstraints gbc_btnLoadSettings = new GridBagConstraints();
		gbc_btnLoadSettings.insets = new Insets(0, 0, 5, 5);
		gbc_btnLoadSettings.gridx = 1;
		gbc_btnLoadSettings.gridy = 1;
		add(btnLoadSettings, gbc_btnLoadSettings);

		lblScale = new JLabel("scale=");
		GridBagConstraints gbc_lblScale = new GridBagConstraints();
		gbc_lblScale.insets = new Insets(0, 0, 5, 5);
		gbc_lblScale.anchor = GridBagConstraints.EAST;
		gbc_lblScale.gridx = 1;
		gbc_lblScale.gridy = 2;
		add(lblScale, gbc_lblScale);

		txtscale = new JTextField();
		txtscale.setText(""+scale);
		GridBagConstraints gbc_txtscale = new GridBagConstraints();
		gbc_txtscale.insets = new Insets(0, 0, 5, 0);
		gbc_txtscale.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtscale.gridx = 2;
		gbc_txtscale.gridy = 2;
		add(txtscale, gbc_txtscale);
		txtscale.setColumns(10);

		JLabel lblS = new JLabel("S=");
		GridBagConstraints gbc_lblS = new GridBagConstraints();
		gbc_lblS.insets = new Insets(0, 0, 5, 5);
		gbc_lblS.anchor = GridBagConstraints.EAST;
		gbc_lblS.gridx = 1;
		gbc_lblS.gridy = 3;
		add(lblS, gbc_lblS);

		txtS = new JTextField();
		txtS.setText(""+S);
		GridBagConstraints gbc_txtS = new GridBagConstraints();
		gbc_txtS.insets = new Insets(0, 0, 5, 0);
		gbc_txtS.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtS.gridx = 2;
		gbc_txtS.gridy = 3;
		add(txtS, gbc_txtS);
		txtS.setColumns(10);

		lblL = new JLabel("L=");
		GridBagConstraints gbc_lblL = new GridBagConstraints();
		gbc_lblL.insets = new Insets(0, 0, 5, 5);
		gbc_lblL.anchor = GridBagConstraints.EAST;
		gbc_lblL.gridx = 1;
		gbc_lblL.gridy = 4;
		add(lblL, gbc_lblL);

		txtL = new JTextField();
		txtL.setText(""+L);
		GridBagConstraints gbc_txtL = new GridBagConstraints();
		gbc_txtL.insets = new Insets(0, 0, 5, 0);
		gbc_txtL.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtL.gridx = 2;
		gbc_txtL.gridy = 4;
		add(txtL, gbc_txtL);
		txtL.setColumns(10);

		lblR = new JLabel("R=");
		GridBagConstraints gbc_lblR = new GridBagConstraints();
		gbc_lblR.insets = new Insets(0, 0, 5, 5);
		gbc_lblR.anchor = GridBagConstraints.EAST;
		gbc_lblR.gridx = 1;
		gbc_lblR.gridy = 5;
		add(lblR, gbc_lblR);

		txtR = new JTextField();
		txtR.setText(""+R);
		GridBagConstraints gbc_txtR = new GridBagConstraints();
		gbc_txtR.insets = new Insets(0, 0, 5, 0);
		gbc_txtR.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtR.gridx = 2;
		gbc_txtR.gridy = 5;
		add(txtR, gbc_txtR);
		txtR.setColumns(10);

		lblVmin = new JLabel("V_min=");
		GridBagConstraints gbc_lblVmin = new GridBagConstraints();
		gbc_lblVmin.insets = new Insets(0, 0, 5, 5);
		gbc_lblVmin.anchor = GridBagConstraints.EAST;
		gbc_lblVmin.gridx = 1;
		gbc_lblVmin.gridy = 6;
		add(lblVmin, gbc_lblVmin);

		txtV_min = new JTextField();
		txtV_min.setText(""+V_min);
		GridBagConstraints gbc_txtV_min = new GridBagConstraints();
		gbc_txtV_min.insets = new Insets(0, 0, 5, 0);
		gbc_txtV_min.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtV_min.gridx = 2;
		gbc_txtV_min.gridy = 6;
		add(txtV_min, gbc_txtV_min);
		txtV_min.setColumns(10);

		lblGranA = new JLabel("GranA=");
		GridBagConstraints gbc_lblGranA = new GridBagConstraints();
		gbc_lblGranA.insets = new Insets(0, 0, 5, 5);
		gbc_lblGranA.anchor = GridBagConstraints.ABOVE_BASELINE_TRAILING;
		gbc_lblGranA.gridx = 1;
		gbc_lblGranA.gridy = 7;
		add(lblGranA, gbc_lblGranA);

		txtGranA = new JTextField();
		txtGranA.setText(""+GranA);
		GridBagConstraints gbc_txtGranA = new GridBagConstraints();
		gbc_txtGranA.insets = new Insets(0, 0, 5, 0);
		gbc_txtGranA.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGranA.gridx = 2;
		gbc_txtGranA.gridy = 7;
		add(txtGranA, gbc_txtGranA);
		txtGranA.setColumns(10);

		JLabel lblW = new JLabel("W=");
		GridBagConstraints gbc_lblW = new GridBagConstraints();
		gbc_lblW.insets = new Insets(0, 0, 5, 5);
		gbc_lblW.anchor = GridBagConstraints.EAST;
		gbc_lblW.gridx = 1;
		gbc_lblW.gridy = 8;
		add(lblW, gbc_lblW);

		txtW = new JTextField();
		txtW.setText(""+W);
		GridBagConstraints gbc_txtW = new GridBagConstraints();
		gbc_txtW.insets = new Insets(0, 0, 5, 0);
		gbc_txtW.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtW.gridx = 2;
		gbc_txtW.gridy = 8;
		add(txtW, gbc_txtW);
		txtW.setColumns(10);

		JLabel lblNormx = new JLabel("NormX=");
		GridBagConstraints gbc_lblNormx = new GridBagConstraints();
		gbc_lblNormx.insets = new Insets(0, 0, 5, 5);
		gbc_lblNormx.anchor = GridBagConstraints.EAST;
		gbc_lblNormx.gridx = 1;
		gbc_lblNormx.gridy = 9;
		add(lblNormx, gbc_lblNormx);

		txtNormX = new JTextField();
		txtNormX.setText(""+NormX);
		GridBagConstraints gbc_txtNormX = new GridBagConstraints();
		gbc_txtNormX.insets = new Insets(0, 0, 5, 0);
		gbc_txtNormX.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNormX.gridx = 2;
		gbc_txtNormX.gridy = 9;
		add(txtNormX, gbc_txtNormX);
		txtNormX.setColumns(10);

		lblNblane = new JLabel("nb_lane=");
		GridBagConstraints gbc_lblNblane = new GridBagConstraints();
		gbc_lblNblane.insets = new Insets(0, 0, 5, 5);
		gbc_lblNblane.anchor = GridBagConstraints.EAST;
		gbc_lblNblane.gridx = 1;
		gbc_lblNblane.gridy = 10;
		add(lblNblane, gbc_lblNblane);

		txtnb_lane = new JTextField();
		txtnb_lane.setText(""+nb_lane);
		GridBagConstraints gbc_txtnb_lane = new GridBagConstraints();
		gbc_txtnb_lane.insets = new Insets(0, 0, 5, 0);
		gbc_txtnb_lane.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtnb_lane.gridx = 2;
		gbc_txtnb_lane.gridy = 10;
		add(txtnb_lane, gbc_txtnb_lane);
		txtnb_lane.setColumns(10);

		lblEndjunction = new JLabel("end_junction=");
		GridBagConstraints gbc_lblEndjunction = new GridBagConstraints();
		gbc_lblEndjunction.insets = new Insets(0, 0, 5, 5);
		gbc_lblEndjunction.anchor = GridBagConstraints.EAST;
		gbc_lblEndjunction.gridx = 1;
		gbc_lblEndjunction.gridy = 11;
		add(lblEndjunction, gbc_lblEndjunction);

		txtend_junction = new JTextField();
		txtend_junction.setText(""+end_junction);
		GridBagConstraints gbc_txtend_junction = new GridBagConstraints();
		gbc_txtend_junction.insets = new Insets(0, 0, 5, 0);
		gbc_txtend_junction.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtend_junction.gridx = 2;
		gbc_txtend_junction.gridy = 11;
		add(txtend_junction, gbc_txtend_junction);
		txtend_junction.setColumns(10);

		lblBeginjunction = new JLabel("begin_junction=");
		GridBagConstraints gbc_lblBeginjunction = new GridBagConstraints();
		gbc_lblBeginjunction.insets = new Insets(0, 0, 5, 5);
		gbc_lblBeginjunction.anchor = GridBagConstraints.EAST;
		gbc_lblBeginjunction.gridx = 1;
		gbc_lblBeginjunction.gridy = 12;
		add(lblBeginjunction, gbc_lblBeginjunction);

		txtbegin_junction = new JTextField();
		txtbegin_junction.setText(""+begin_junction);
		GridBagConstraints gbc_txtbegin_junction = new GridBagConstraints();
		gbc_txtbegin_junction.insets = new Insets(0, 0, 5, 0);
		gbc_txtbegin_junction.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtbegin_junction.gridx = 2;
		gbc_txtbegin_junction.gridy = 12;
		add(txtbegin_junction, gbc_txtbegin_junction);
		txtbegin_junction.setColumns(10);

		lblMarking = new JLabel("marking=");
		GridBagConstraints gbc_lblMarking = new GridBagConstraints();
		gbc_lblMarking.anchor = GridBagConstraints.EAST;
		gbc_lblMarking.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarking.gridx = 1;
		gbc_lblMarking.gridy = 13;
		add(lblMarking, gbc_lblMarking);

		btnDefine = new JButton("Define");
		btnDefine.addActionListener(new Define_marking(this));
		GridBagConstraints gbc_btnDefine = new GridBagConstraints();
		gbc_btnDefine.anchor = GridBagConstraints.WEST;
		gbc_btnDefine.insets = new Insets(0, 0, 5, 0);
		gbc_btnDefine.gridx = 2;
		gbc_btnDefine.gridy = 13;
		add(btnDefine, gbc_btnDefine);

		lblnb_car = new JLabel("nb_car=");
		GridBagConstraints gbc_lblnb_car = new GridBagConstraints();
		gbc_lblnb_car.insets = new Insets(0, 0, 5, 5);
		gbc_lblnb_car.anchor = GridBagConstraints.EAST;
		gbc_lblnb_car.gridx = 1;
		gbc_lblnb_car.gridy = 14;
		add(lblnb_car, gbc_lblnb_car);

		txtnb_car = new JTextField();
		txtnb_car.setText(""+nb_car);
		GridBagConstraints gbc_txtnb_car = new GridBagConstraints();
		gbc_txtnb_car.insets = new Insets(0, 0, 5, 0);
		gbc_txtnb_car.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtnb_car.gridx = 2;
		gbc_txtnb_car.gridy = 14;
		add(txtnb_car, gbc_txtnb_car);
		txtnb_car.setColumns(10);

		lblSafetylength = new JLabel("safety_length=");
		GridBagConstraints gbc_lblSafetylength = new GridBagConstraints();
		gbc_lblSafetylength.insets = new Insets(0, 0, 5, 5);
		gbc_lblSafetylength.anchor = GridBagConstraints.EAST;
		gbc_lblSafetylength.gridx = 1;
		gbc_lblSafetylength.gridy = 15;
		add(lblSafetylength, gbc_lblSafetylength);

		txtsafety_length = new JTextField();
		txtsafety_length.setText(""+safety_length);
		GridBagConstraints gbc_txtsafety_length = new GridBagConstraints();
		gbc_txtsafety_length.insets = new Insets(0, 0, 5, 0);
		gbc_txtsafety_length.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtsafety_length.gridx = 2;
		gbc_txtsafety_length.gridy = 15;
		add(txtsafety_length, gbc_txtsafety_length);
		txtsafety_length.setColumns(10);

		lblSafetywidth = new JLabel("safety_width=");
		GridBagConstraints gbc_lblSafetywidth = new GridBagConstraints();
		gbc_lblSafetywidth.insets = new Insets(0, 0, 5, 5);
		gbc_lblSafetywidth.anchor = GridBagConstraints.EAST;
		gbc_lblSafetywidth.gridx = 1;
		gbc_lblSafetywidth.gridy = 16;
		add(lblSafetywidth, gbc_lblSafetywidth);

		txtsafety_width = new JTextField();
		txtsafety_width.setText(""+safety_width);
		GridBagConstraints gbc_txtsafety_width = new GridBagConstraints();
		gbc_txtsafety_width.insets = new Insets(0, 0, 5, 0);
		gbc_txtsafety_width.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtsafety_width.gridx = 2;
		gbc_txtsafety_width.gridy = 16;
		add(txtsafety_width, gbc_txtsafety_width);
		txtsafety_width.setColumns(10);

		lbltraj_length = new JLabel("traj_length=");
		GridBagConstraints gbc_lbltraj_length = new GridBagConstraints();
		gbc_lbltraj_length.insets = new Insets(0, 0, 5, 5);
		gbc_lbltraj_length.anchor = GridBagConstraints.EAST;
		gbc_lbltraj_length.gridx = 1;
		gbc_lbltraj_length.gridy = 17;
		add(lbltraj_length, gbc_lbltraj_length);

		txttraj_length = new JTextField();
		txttraj_length.setText(""+traj_length);
		GridBagConstraints gbc_txttraj_length = new GridBagConstraints();
		gbc_txttraj_length.insets = new Insets(0, 0, 5, 0);
		gbc_txttraj_length.fill = GridBagConstraints.HORIZONTAL;
		gbc_txttraj_length.gridx = 2;
		gbc_txttraj_length.gridy = 17;
		add(txttraj_length, gbc_txttraj_length);
		txttraj_length.setColumns(10);

		lblDelayStep = new JLabel("delay_step=");
		GridBagConstraints gbc_lblDelayStep = new GridBagConstraints();
		gbc_lblDelayStep.insets = new Insets(0, 0, 5, 5);
		gbc_lblDelayStep.anchor = GridBagConstraints.EAST;
		gbc_lblDelayStep.gridx = 1;
		gbc_lblDelayStep.gridy = 18;
		add(lblDelayStep, gbc_lblDelayStep);

		txtdelay_step = new JTextField();
		txtdelay_step.setText(""+delay_step);
		GridBagConstraints gbc_txtdelay_step = new GridBagConstraints();
		gbc_txtdelay_step.insets = new Insets(0, 0, 5, 0);
		gbc_txtdelay_step.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtdelay_step.gridx = 2;
		gbc_txtdelay_step.gridy = 18;
		add(txtdelay_step, gbc_txtdelay_step);
		txtdelay_step.setColumns(10);

		lblMaxdelay = new JLabel("max_delay=");
		GridBagConstraints gbc_lblMaxdelay = new GridBagConstraints();
		gbc_lblMaxdelay.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaxdelay.anchor = GridBagConstraints.EAST;
		gbc_lblMaxdelay.gridx = 1;
		gbc_lblMaxdelay.gridy = 19;
		add(lblMaxdelay, gbc_lblMaxdelay);

		txtmax_delay = new JTextField();
		txtmax_delay.setText(""+max_delay);
		GridBagConstraints gbc_txtmax_delay = new GridBagConstraints();
		gbc_txtmax_delay.insets = new Insets(0, 0, 5, 0);
		gbc_txtmax_delay.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtmax_delay.gridx = 2;
		gbc_txtmax_delay.gridy = 19;
		add(txtmax_delay, gbc_txtmax_delay);
		txtmax_delay.setColumns(10);

		btnCarsSettings = new JButton("Cars settings");
		btnCarsSettings.addActionListener(new Cars_settings(this));
		GridBagConstraints gbc_btnCarsSettings = new GridBagConstraints();
		gbc_btnCarsSettings.anchor = GridBagConstraints.WEST;
		gbc_btnCarsSettings.insets = new Insets(0, 0, 5, 0);
		gbc_btnCarsSettings.gridx = 2;
		gbc_btnCarsSettings.gridy = 20;
		add(btnCarsSettings, gbc_btnCarsSettings);

		lblDEVELOPPEROPTION = new JLabel("///////////////////////////////////DEVELOPPER OPTION///////////////////////////////////");
		GridBagConstraints gbc_lblDEVELOPPEROPTION = new GridBagConstraints();
		gbc_lblDEVELOPPEROPTION.gridwidth = 3;
		gbc_lblDEVELOPPEROPTION.insets = new Insets(0, 0, 5, 0);
		gbc_lblDEVELOPPEROPTION.gridx = 0;
		gbc_lblDEVELOPPEROPTION.gridy = 21;
		add(lblDEVELOPPEROPTION, gbc_lblDEVELOPPEROPTION);

		btnEditCode = new JButton("Edit code");
		btnEditCode.addActionListener(new Edit_code());
		GridBagConstraints gbc_btnEditCode = new GridBagConstraints();
		gbc_btnEditCode.insets = new Insets(0, 0, 5, 0);
		gbc_btnEditCode.gridwidth = 3;
		gbc_btnEditCode.gridx = 0;
		gbc_btnEditCode.gridy = 22;
		add(btnEditCode, gbc_btnEditCode);

		btnEditQueries = new JButton("Edit queries");
		btnEditQueries.addActionListener(new Edit_queries());
		GridBagConstraints gbc_btnEditQueries = new GridBagConstraints();
		gbc_btnEditQueries.gridwidth = 3;
		gbc_btnEditQueries.insets = new Insets(0, 0, 5, 0);
		gbc_btnEditQueries.gridx = 0;
		gbc_btnEditQueries.gridy = 23;
		add(btnEditQueries, gbc_btnEditQueries);

		lblNewLabel = new JLabel("///////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 24;
		add(lblNewLabel, gbc_lblNewLabel);

		btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new Finish(app,this));
		GridBagConstraints gbc_btnFinish = new GridBagConstraints();
		gbc_btnFinish.gridwidth = 3;
		gbc_btnFinish.gridx = 0;
		gbc_btnFinish.gridy = 25;
		add(btnFinish, gbc_btnFinish);

		this.app.setVisible(true);

	}

	public int EditableFalse(){
		txtS.setEditable(false);
		txtL.setEditable(false);
		txtscale.setEditable(false);
		txtR.setEditable(false);
		txtV_min.setEditable(false);
		txtGranA.setEditable(false);
		txtW.setEditable(false);
		txtNormX.setEditable(false);
		txtnb_lane.setEditable(false);
		txtend_junction.setEditable(false);
		txtbegin_junction.setEditable(false);
		txtnb_car.setEditable(false);
		txtsafety_length.setEditable(false);
		txtsafety_width.setEditable(false);
		txttraj_length.setEditable(false);
		txtdelay_step.setEditable(false);
		txtmax_delay.setEditable(false);
		btnDefine.setEnabled(false);
		btnCarsSettings.setEnabled(false);
		btnEditCode.setEnabled(false);
		btnFinish.setEnabled(false);
		btnEditQueries.setEnabled(false);
		btnLoadSettings.setEnabled(false);
		return 0;

	}

	public int EditableTrue(){
		txtS.setEditable(true);
		txtL.setEditable(true);
		txtscale.setEditable(true);
		txtR.setEditable(true);
		txtV_min.setEditable(true);
		txtGranA.setEditable(true);
		txtW.setEditable(true);
		txtNormX.setEditable(true);
		txtnb_lane.setEditable(true);
		txtend_junction.setEditable(true);
		txtbegin_junction.setEditable(true);
		txtnb_car.setEditable(true);
		txtsafety_length.setEditable(true);
		txtsafety_width.setEditable(true);
		txttraj_length.setEditable(true);
		txtdelay_step.setEditable(true);
		txtmax_delay.setEditable(true);
		btnDefine.setEnabled(true);
		btnCarsSettings.setEnabled(true);
		btnEditCode.setEnabled(true);
		btnFinish.setEnabled(true);
		btnEditQueries.setEnabled(true);
		btnLoadSettings.setEnabled(true);
		return 0;
	}

	public Application getApp() {
		return app;
	}

	public void setApp(Application app) {
		this.app = app;
	}

	public void load(Param_set set){
		this.scale=set.getScale();
		this.S=set.getS();
		this.L=set.getL();
		this.R=set.getR();
		this.V_min=set.getV_min();
		this.GranA=set.getGranA();
		this.W=set.getW();
		this.NormX=set.getW();
		this.nb_lane=set.getNb_lane();
		this.end_junction=set.getEnd_junction();
		this.begin_junction=set.getBegin_junction();
		this.marking=set.getMarking();
		this.nb_car=set.getNb_car();
		this.safety_length=set.getSafety_length();
		this.safety_width=set.getSafety_width();
		this.traj_length=set.getTraj_length();
		this.delay_step=set.getDelay_step();
		this.max_delay=set.getMax_delay();
		this.Car_list=set.getCar_list();

		this.navigation_points_max=set.getNavigation_points_max();
		this.V_max=set.getV_max();
		this.A_min=set.getA_min();
		this.A_max=set.getA_max();
	}

	public Param_set extract(){
		return new Param_set(this.getScale(), this.getS(), this.getL(), this.getR(), this.getV_min(), this.getGranA(), this.getW(), this.NormX, this.nb_lane, this.end_junction, this.begin_junction, this.getMarking(), this.getNb_car(), this.safety_length, this.safety_width, this.getTraj_length(), this.getDelay_step(), this.getMax_delay(), this.getCar_list(), this.getNavigation_points_max(), this.getV_max(), this.getA_min(), this.getA_max());

	}

	//calculable
	public int getNavigation_points_max() {
		return navigation_points_max;
	}

	public void setNavigation_points_max(int navigation_points_max) {
		this.navigation_points_max = navigation_points_max;
	}

	//calculable
	public int getV_max() {
		return V_max;
	}

	public void setV_max(int v_max) {
		V_max = v_max;
	}

	//calculable
	public int getA_min() {
		return A_min;
	}

	public void setA_min(int a_min) {
		A_min = a_min;
	}

	//calculable
	public int getA_max() {
		return A_max;
	}

	public void setA_max(int a_max) {
		A_max = a_max;
	}

	public ArrayList<Car_set> getCar_list() {
		return Car_list;
	}

	public void setCar_list(ArrayList<Car_set> car_list) {
		Car_list = car_list;
	}

	public int getScale() {
		this.scale=Integer.parseInt(txtscale.getText());
		return scale;
	}

	public int getS() {
		this.S=Integer.parseInt(txtS.getText());
		return S;
	}

	public int getL() {
		this.L=Integer.parseInt(txtL.getText());
		return L;
	}

	public int getR() {
		this.R=Integer.parseInt(txtR.getText());
		return R;
	}

	public int getV_min() {
		this.V_min=Integer.parseInt(txtV_min.getText());
		return V_min;
	}

	public int getGranA() {
		this.GranA=Integer.parseInt(txtGranA.getText());
		return GranA;
	}

	public int getW() {
		this.W=Integer.parseInt(txtW.getText());
		return W;
	}

	public int getNormX() {
		this.NormX=Integer.parseInt(txtNormX.getText());
		return NormX;
	}

	public int getNb_lane() {
		this.nb_lane=Integer.parseInt(txtnb_lane.getText());
		return nb_lane;
	}

	public int getEnd_junction() {
		this.end_junction=Integer.parseInt(txtend_junction.getText());
		return end_junction;
	}

	public int getBegin_junction() {
		this.begin_junction=Integer.parseInt(txtbegin_junction.getText());
		return begin_junction;
	}

	public void setMarking(ArrayList<Integer> marking) {
		this.marking= marking;
	}

	public ArrayList<Integer> getMarking() {
		return marking;
	}

	public int getNb_car() {
		this.nb_car=Integer.parseInt(txtnb_car.getText());
		return nb_car;
	}

	public int getSafety_length() {
		safety_length=Integer.parseInt(txtsafety_length.getText());
		return safety_length;
	}

	public int getSafety_width() {
		safety_width=Integer.parseInt(txtsafety_width.getText());
		return safety_width;
	}

	public int getTraj_length() {
		traj_length=Integer.parseInt(txttraj_length.getText());
		return traj_length;
	}

	public int getDelay_step() {
		delay_step=Integer.parseInt(txtdelay_step.getText());
		return delay_step;
	}

	public int getMax_delay() {
		max_delay=Integer.parseInt(txtmax_delay.getText());
		return max_delay;
	}


	public JTextField getTxtS() {
		return txtS;
	}

	public void setTxtS(JTextField txtS) {
		this.txtS = txtS;
	}

	public JTextField getTxtL() {
		return txtL;
	}

	public void setTxtL(JTextField txtL) {
		this.txtL = txtL;
	}

	public JTextField getTxtscale() {
		return txtscale;
	}

	public void setTxtscale(JTextField txtscale) {
		this.txtscale = txtscale;
	}

	public JTextField getTxtR() {
		return txtR;
	}

	public void setTxtR(JTextField txtR) {
		this.txtR = txtR;
	}

	public JTextField getTxtV_min() {
		return txtV_min;
	}

	public void setTxtV_min(JTextField txtV_min) {
		this.txtV_min = txtV_min;
	}

	public JTextField getTxtGranA() {
		return txtGranA;
	}

	public void setTxtGranA(JTextField txtGranA) {
		this.txtGranA = txtGranA;
	}

	public JTextField getTxtW() {
		return txtW;
	}

	public void setTxtW(JTextField txtW) {
		this.txtW = txtW;
	}

	public JTextField getTxtNormX() {
		return txtNormX;
	}

	public void setTxtNormX(JTextField txtNormX) {
		this.txtNormX = txtNormX;
	}

	public JTextField getTxtnb_lane() {
		return txtnb_lane;
	}

	public void setTxtnb_lane(JTextField txtnb_lane) {
		this.txtnb_lane = txtnb_lane;
	}

	public JTextField getTxtend_junction() {
		return txtend_junction;
	}

	public void setTxtend_junction(JTextField txtend_junction) {
		this.txtend_junction = txtend_junction;
	}

	public JTextField getTxtbegin_junction() {
		return txtbegin_junction;
	}

	public void setTxtbegin_junction(JTextField txtbegin_junction) {
		this.txtbegin_junction = txtbegin_junction;
	}

	public JTextField getTxtnb_car() {
		return txtnb_car;
	}

	public void setTxtnb_car(JTextField txtnb_car) {
		this.txtnb_car = txtnb_car;
	}

	public JTextField getTxtsafety_length() {
		return txtsafety_length;
	}

	public void setTxtsafety_length(JTextField txtsafety_length) {
		this.txtsafety_length = txtsafety_length;
	}

	public JTextField getTxtsafety_width() {
		return txtsafety_width;
	}

	public void setTxtsafety_width(JTextField txtsafety_width) {
		this.txtsafety_width = txtsafety_width;
	}

	public JTextField getTxttraj_length() {
		return txttraj_length;
	}

	public void setTxttraj_length(JTextField txttraj_length) {
		this.txttraj_length = txttraj_length;
	}

	public JTextField getTxtdelay_step() {
		return txtdelay_step;
	}

	public void setTxtdelay_step(JTextField txtdelay_step) {
		this.txtdelay_step = txtdelay_step;
	}

	public JTextField getTxtmax_delay() {
		return txtmax_delay;
	}

	public void setTxtmax_delay(JTextField txtmax_delay) {
		this.txtmax_delay = txtmax_delay;
	}

}
