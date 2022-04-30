package ir.soleimani.cablesizer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    public Context context;


    List<String> crossSections = new ArrayList<>();

    public final String AIR = "Air" , GROUND = "Ground" , DIRECT_BURIED = "Direct Buried" ,
    CABLE_IN_DUCTS = "Cables in Ducts" , SINGLE_CORE = "One" , THREE_CORE = "Three" ,
    PVC = "PVC" , XLPE = "XLPE" , VERY_WET = "Very Wet" , WET = "Wet" , DAMP = "Damp" ,
    DRY = "Dry" , VERY_DRY = "Very Dry" , PHT = "On Perforated - Horizontal - Touching" ,
    PHS = "On Perforated - Horizontal - Spaced" , PVS = "On Perforated - Vertical - Spaced",
    LHT = "On Ladder - Horizontal - Touching" ,PVT = "On Perforated - Vertical - Touching",
    LHS = "On Ladder - Horizontal - Spaced" , TOUCHING = "Touching" , ONE_PHASE = "One_Phase" ,
    THREE_PHASE = "Three_Phase" , COOPER = "Cooper" , ALUMINIUM = "Aluminium" , EPR = "EPR" , TREFOIL = "Trefoil" , SPACED = "Spaced" ,
    ARMOURED = "Armoured" , UNARMOURED = "Unarmoured";

    public static String SType = null , SInsulationMaterial = null , SInstallation = null ,
    SAmbientTemperature = null ,  SCurrentType = null , SNumberOfCables_soil = null ,
    SSpacing_soil = null , SInstallationMethod_soil = null , SDepth_soil = null , SNature_soil = null ,
    SCablesInTray_air = null , SNumberOfTray_air = null , SInstallationMethod_air = null , SPhases = null , SNumber_Cores = null ,
    SNatureOfSoil_1p = null , step1 = null , step2 = null;

    public static int IVoltage = 0 , ICurrent = 0 ,
    ILength = 0 , IShortCircuit = 0;

    public static double DPowerFactor = 0.0 ,  DVoltageDrop = 0.0 ;

    public Spinner type,installation,temp,insulation_material,soilNature,depth,soilSpace,soilInstallationMethod,soilCableNumber,airTrayNumber,airInstallationMethod,airCableNumber,soilNature1p;
    public RadioButton one_core,three_core,one_phase,three_phase;
    public EditText voltage,current,voltage_drop,length,power_factor,short_circuit;
    public TextView crossSection,run,voltage_drop_result;
    public Button next1,next2,calc,back2,back3,back4;
    public LinearLayout layout_soil_3p,layout_soil_1p,layout_air;


    public HashMap<String , Double> resistance = new HashMap<>();
    public HashMap<String , Double> reactance = new HashMap<>();



    public HashMap<String , HashMap<String , HashMap<String , HashMap<String , HashMap<String , HashMap<Integer , String>>>>>> currentCapacity = new HashMap<>();

    public HashMap<String , HashMap<String , HashMap<String , HashMap<String , HashMap<Integer , String>>>>> currentCapacity_single = new HashMap<>();
    public HashMap<String , HashMap<String , HashMap<String , HashMap<Integer , String>>>> currentCapacity_single_cooper = new HashMap<>();
    public HashMap<String , HashMap<String , HashMap<Integer , String>>> currentCapacity_single_cooper_XLPE = new HashMap<>();
    public HashMap<String , HashMap<Integer , String>> currentCapacity_single_cooper_XLPE_direct = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_single_cooper_XLPE_direct_trefoil = new HashMap<>();
    public HashMap<Integer , String>currentCapacity_single_cooper_XLPE_direct_spaced = new HashMap<>();
    public HashMap<String , HashMap<Integer , String>> currentCapacity_single_cooper_XLPE_duct = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_single_cooper_XLPE_duct_trefoil = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_single_cooper_XLPE_duct_touching = new HashMap<>();
    public HashMap<String , HashMap<Integer , String>> currentCapacity_single_cooper_XLPE_air = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_single_cooper_XLPE_air_trefoil = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_single_cooper_XLPE_air_touching = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_single_cooper_XLPE_air_spaced = new HashMap<>();
    public HashMap<String , HashMap<String , HashMap<Integer , String>>> currentCapacity_single_cooper_EPR = new HashMap<>();
    public HashMap<String , HashMap<Integer , String>> currentCapacity_single_cooper_EPR_direct = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_single_cooper_EPR_direct_trefoil = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_single_cooper_EPR_direct_spaced = new HashMap<>();
    public HashMap<String , HashMap<Integer , String>> currentCapacity_single_cooper_EPR_duct = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_single_cooper_EPR_duct_trefoil = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_single_cooper_EPR_duct_touching = new HashMap<>();
    public HashMap<String , HashMap<Integer , String>> currentCapacity_single_cooper_EPR_air = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_single_cooper_EPR_air_trefoil = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_single_cooper_EPR_air_touching = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_single_cooper_EPR_air_spaced = new HashMap<>();


    public HashMap<String , HashMap<String , HashMap<String , HashMap<Integer , String>>>> currentCapacity_single_aluminium = new HashMap<>();
    public HashMap<String , HashMap<String , HashMap<Integer , String>>> currentCapacity_single_aluminium_XLPE = new HashMap<>();
    public HashMap<String , HashMap<Integer , String>> currentCapacity_single_aluminium_XLPE_direct = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_single_aluminium_XLPE_direct_trefoil = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_single_aluminium_XLPE_direct_spaced = new HashMap<>();
    public HashMap<String , HashMap<Integer , String>> currentCapacity_single_aluminium_XLPE_duct = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_single_aluminium_XLPE_duct_trefoil = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_single_aluminium_XLPE_duct_touching = new HashMap<>();
    public HashMap<String , HashMap<Integer , String>> currentCapacity_single_aluminium_XLPE_air = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_single_aluminium_XLPE_air_trefoil = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_single_aluminium_XLPE_air_touching = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_single_aluminium_XLPE_air_spaced = new HashMap<>();
    public HashMap<String , HashMap<String , HashMap<Integer , String>>> currentCapacity_single_aluminium_EPR = new HashMap<>();
    public HashMap<String , HashMap<Integer , String>> currentCapacity_single_aluminium_EPR_direct = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_single_aluminium_EPR_direct_trefoil = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_single_aluminium_EPR_direct_spaced = new HashMap<>();
    public HashMap<String , HashMap<Integer , String>> currentCapacity_single_aluminium_EPR_duct = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_single_aluminium_EPR_duct_trefoil = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_single_aluminium_EPR_duct_touching = new HashMap<>();
    public HashMap<String , HashMap<Integer , String>> currentCapacity_single_aluminium_EPR_air = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_single_aluminium_EPR_air_trefoil = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_single_aluminium_EPR_air_touching = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_single_aluminium_EPR_air_spaced = new HashMap<>();

    public HashMap<String , HashMap<String , HashMap<String , HashMap<String , HashMap<Integer , String>>>>> currentCapacity_multi = new HashMap<>();
    public HashMap<String , HashMap<String , HashMap<String , HashMap<Integer , String>>>> currentCapacity_multi_cooper = new HashMap<>();
    public HashMap<String , HashMap<String , HashMap<Integer , String>>> currentCapacity_multi_cooper_XLPE = new HashMap<>();
    public HashMap<String , HashMap<Integer , String>> currentCapacity_multi_cooper_XLPE_armoured = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_multi_cooper_XLPE_armoured_direct = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_multi_cooper_XLPE_armoured_duct = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_multi_cooper_XLPE_armoured_air = new HashMap<>();
    public HashMap<String , HashMap<Integer , String>> currentCapacity_multi_cooper_XLPE_unarmoured = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_multi_cooper_XLPE_unarmoured_direct = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_multi_cooper_XLPE_unarmoured_duct = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_multi_cooper_XLPE_unarmoured_air = new HashMap<>();
    public HashMap<String , HashMap<String , HashMap<Integer , String>>> currentCapacity_multi_cooper_EPR = new HashMap<>();
    public HashMap<String , HashMap<Integer , String>> currentCapacity_multi_cooper_EPR_armoured = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_multi_cooper_EPR_armoured_direct = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_multi_cooper_EPR_armoured_duct = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_multi_cooper_EPR_armoured_air = new HashMap<>();
    public HashMap<String , HashMap<Integer , String>> currentCapacity_multi_cooper_EPR_unarmoured = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_multi_cooper_EPR_unarmoured_direct = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_multi_cooper_EPR_unarmoured_duct = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_multi_cooper_EPR_unarmoured_air = new HashMap<>();

    public HashMap<String , HashMap<String , HashMap<String , HashMap<Integer , String>>>> currentCapacity_multi_aluminium = new HashMap<>();
    public HashMap<String , HashMap<String , HashMap<Integer , String>>> currentCapacity_multi_aluminium_XLPE = new HashMap<>();
    public HashMap<String , HashMap<Integer , String>> currentCapacity_multi_aluminium_XLPE_armoured = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_multi_aluminium_XLPE_armoured_direct = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_multi_aluminium_XLPE_armoured_duct = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_multi_aluminium_XLPE_armoured_air = new HashMap<>();
    public HashMap<String , HashMap<Integer , String>> currentCapacity_multi_aluminium_XLPE_unarmoured = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_multi_aluminium_XLPE_unarmoured_direct = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_multi_aluminium_XLPE_unarmoured_duct = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_multi_aluminium_XLPE_unarmoured_air = new HashMap<>();
    public HashMap<String , HashMap<String , HashMap<Integer , String>>> currentCapacity_multi_aluminium_EPR = new HashMap<>();
    public HashMap<String , HashMap<Integer , String>> currentCapacity_multi_aluminium_EPR_armoured = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_multi_aluminium_EPR_armoured_direct = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_multi_aluminium_EPR_armoured_duct = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_multi_aluminium_EPR_armoured_air = new HashMap<>();
    public HashMap<String , HashMap<Integer , String>> currentCapacity_multi_aluminium_EPR_unarmoured = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_multi_aluminium_EPR_unarmoured_direct = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_multi_aluminium_EPR_unarmoured_duct = new HashMap<>();
    public HashMap<Integer , String> currentCapacity_multi_aluminium_EPR_unarmoured_air = new HashMap<>();









    public HashMap<String , HashMap<String,HashMap>> temperature = new HashMap<>();

    public HashMap<String , Double> ambientTempPVC = new HashMap<>();
    public HashMap<String , Double> ambientTempXLPE = new HashMap<>();

    public HashMap<String , Double> groundTempPVC = new HashMap<>();
    public HashMap<String , Double> groundTempXLPE = new HashMap<>();

    public HashMap<String, HashMap> ambientTemp = new HashMap<>();
    public HashMap<String , HashMap> groundTemp = new HashMap<>();

    public HashMap<String , Double> natureOfSoil = new HashMap<>();


    public HashMap<String , HashMap> depthOfLaying = new HashMap<>();
    public HashMap<String , HashMap> depth_Direct = new HashMap<>();
    public HashMap<String , HashMap> depth_Duct = new HashMap<>();
    public HashMap<String , Double> depth_Direct_Single = new HashMap<>();
    public HashMap<String , Double> depth_Direct_Three = new HashMap<>();
    public HashMap<String , Double> depth_Duct_Single = new HashMap<>();
    public HashMap<String , Double> depth_Duct_Three = new HashMap<>();

    public HashMap<String , HashMap> installationMethod = new HashMap<>();

    public HashMap<String , HashMap<String , HashMap<String , HashMap<String , Double>>>> installationMethod_air = new HashMap<>();
    public HashMap<String , HashMap<String , HashMap<String , Double>>> installationMethod_air_single = new HashMap<>();
    public HashMap<String , HashMap<String , HashMap<String , Double>>> installationMethod_air_multi = new HashMap<>();

    public HashMap<String , HashMap<String , HashMap<String , HashMap<String , Double>>>> installationMethod_soil = new HashMap<>();
    public HashMap<String , HashMap<String , HashMap<String , Double>>> installationMethod_soil_single = new HashMap<>();
    public HashMap<String , HashMap<String , HashMap<String , Double>>> installationMethod_soil_multi = new HashMap<>();
    public HashMap<String , HashMap<String , Double>> installationMethod_soil_single_direct = new HashMap<>();
    public HashMap<String , HashMap<String , Double>> installationMethod_soil_single_duct = new HashMap<>();
    public HashMap<String , HashMap<String , Double>> installationMethod_soil_multi_direct = new HashMap<>();
    public HashMap<String , HashMap<String , Double>> installationMethod_soil_multi_duct = new HashMap<>();

    public HashMap<String , Double> installationMethod_soil_single_direct_touching = new HashMap<>();
    public HashMap<String , Double> installationMethod_soil_single_direct_200 = new HashMap<>();
    public HashMap<String , Double> installationMethod_soil_single_direct_400 = new HashMap<>();
    public HashMap<String , Double> installationMethod_soil_single_direct_600 = new HashMap<>();
    public HashMap<String , Double> installationMethod_soil_single_direct_800 = new HashMap<>();

    public HashMap<String , Double> installationMethod_soil_single_duct_touching = new HashMap<>();
    public HashMap<String , Double> installationMethod_soil_single_duct_200 = new HashMap<>();
    public HashMap<String , Double> installationMethod_soil_single_duct_400 = new HashMap<>();
    public HashMap<String , Double> installationMethod_soil_single_duct_600 = new HashMap<>();
    public HashMap<String , Double> installationMethod_soil_single_duct_800 = new HashMap<>();

    public HashMap<String , Double> installationMethod_soil_multi_direct_touching = new HashMap<>();
    public HashMap<String , Double> installationMethod_soil_multi_direct_200 = new HashMap<>();
    public HashMap<String , Double> installationMethod_soil_multi_direct_400 = new HashMap<>();
    public HashMap<String , Double> installationMethod_soil_multi_direct_600 = new HashMap<>();
    public HashMap<String , Double> installationMethod_soil_multi_direct_800 = new HashMap<>();

    public HashMap<String , Double> installationMethod_soil_multi_duct_touching = new HashMap<>();
    public HashMap<String , Double> installationMethod_soil_multi_duct_200 = new HashMap<>();
    public HashMap<String , Double> installationMethod_soil_multi_duct_400 = new HashMap<>();
    public HashMap<String , Double> installationMethod_soil_multi_duct_600 = new HashMap<>();
    public HashMap<String , Double> installationMethod_soil_multi_duct_800 = new HashMap<>();

    public HashMap<String , HashMap<String , Double>> installationMethod_air_multi_PHT = new HashMap<>();
    public HashMap<String , HashMap<String , Double>> installationMethod_air_multi_PHS = new HashMap<>();
    public HashMap<String , HashMap<String , Double>> installationMethod_air_multi_PVT = new HashMap<>();
    public HashMap<String , HashMap<String , Double>> installationMethod_air_multi_PVS = new HashMap<>();
    public HashMap<String , HashMap<String , Double>> installationMethod_air_multi_LHT = new HashMap<>();
    public HashMap<String , HashMap<String , Double>> installationMethod_air_multi_LHS = new HashMap<>();

    public HashMap<String , Double> installationMethod_air_multi_PHT_1t = new HashMap<>();
    public HashMap<String , Double> installationMethod_air_multi_PHT_2t = new HashMap<>();

    public HashMap<String , Double> installationMethod_air_multi_PHS_1t = new HashMap<>();
    public HashMap<String , Double> installationMethod_air_multi_PHS_2t = new HashMap<>();

    public HashMap<String , Double> installationMethod_air_multi_PVT_1t = new HashMap<>();
    public HashMap<String , Double> installationMethod_air_multi_PVT_2t = new HashMap<>();

    public HashMap<String , Double> installationMethod_air_multi_PVS_1t = new HashMap<>();
    public HashMap<String , Double> installationMethod_air_multi_PVS_2t = new HashMap<>();

    public HashMap<String , Double> installationMethod_air_multi_LHT_1t = new HashMap<>();
    public HashMap<String , Double> installationMethod_air_multi_LHT_2t = new HashMap<>();

    public HashMap<String , Double> installationMethod_air_multi_LHS_1t = new HashMap<>();
    public HashMap<String , Double> installationMethod_air_multi_LHS_2t = new HashMap<>();

    public HashMap<String , HashMap<String , Double>> installationMethod_air_single_PHT = new HashMap<>();
    public HashMap<String , HashMap<String , Double>> installationMethod_air_single_PHS = new HashMap<>();
    public HashMap<String , HashMap<String , Double>> installationMethod_air_single_PVT = new HashMap<>();
    public HashMap<String , HashMap<String , Double>> installationMethod_air_single_PVS = new HashMap<>();
    public HashMap<String , HashMap<String , Double>> installationMethod_air_single_LHT = new HashMap<>();
    public HashMap<String , HashMap<String , Double>> installationMethod_air_single_LHS = new HashMap<>();

    public HashMap<String , Double> installationMethod_air_single_PHT_1t = new HashMap<>();
    public HashMap<String , Double> installationMethod_air_single_PHT_2t = new HashMap<>();

    public HashMap<String , Double> installationMethod_air_single_PHS_1t = new HashMap<>();
    public HashMap<String , Double> installationMethod_air_single_PHS_2t = new HashMap<>();

    public HashMap<String , Double> installationMethod_air_single_PVT_1t = new HashMap<>();
    public HashMap<String , Double> installationMethod_air_single_PVT_2t = new HashMap<>();

    public HashMap<String , Double> installationMethod_air_single_PVS_1t = new HashMap<>();
    public HashMap<String , Double> installationMethod_air_single_PVS_2t = new HashMap<>();

    public HashMap<String , Double> installationMethod_air_single_LHT_1t = new HashMap<>();
    public HashMap<String , Double> installationMethod_air_single_LHT_2t = new HashMap<>();

    public HashMap<String , Double> installationMethod_air_single_LHS_1t = new HashMap<>();
    public HashMap<String , Double> installationMethod_air_single_LHS_2t = new HashMap<>();








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        init();
        putValues();


        insulation_material.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (insulation_material.getSelectedItem().toString().equals(PVC)){
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context,
                            R.array.temperature_PVC, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    temp.setAdapter(adapter);

                }
                else if (insulation_material.getSelectedItem().toString().equals(XLPE)){
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context,
                            R.array.temperature, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    temp.setAdapter(adapter);

                }
            }
        });

        soilSpace.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (SSpacing_soil.equals("800")){
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context,
                            R.array.number_of_cables_800, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    soilCableNumber.setAdapter(adapter);
                }
                else{
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context,
                            R.array.number_of_cables, android.R.layout.simple_spinner_item);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    soilCableNumber.setAdapter(adapter);
                }
            }
        });


        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SType = type.getSelectedItem().toString();
                SInsulationMaterial = insulation_material.getSelectedItem().toString();
                SInstallation = installation.getSelectedItem().toString();
                SAmbientTemperature = temp.getSelectedItem().toString();

                if (one_phase.isFocused() && installation.getSelectedItem().toString().equals(GROUND)) {
                    set_visibility(View.GONE , View.GONE , View.VISIBLE);
                    SPhases = ONE_PHASE;
                    SInstallation = GROUND;
                }
                else if (one_phase.isFocused() && installation.getSelectedItem().toString().equals(AIR)){
                    set_visibility(View.GONE , View.GONE , View.GONE);
                    SPhases = ONE_PHASE;
                    SInstallation = AIR;
                }
                else if (three_phase.isFocused() && installation.getSelectedItem().toString().equals(GROUND)){
                    set_visibility(View.GONE , View.VISIBLE , View.GONE);
                    SPhases = THREE_PHASE;
                    SInstallation = GROUND;
                }
                else if (three_phase.isFocused() && installation.getSelectedItem().toString().equals(AIR)){
                    set_visibility(View.VISIBLE , View.GONE , View.GONE);
                    SPhases = THREE_PHASE;
                    SInstallation = AIR;
                }

                setContentView(R.layout.activity_main2);


            }
        });

        next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SNumber_Cores = one_core.isFocused() ? SINGLE_CORE : THREE_CORE;
                SNumberOfCables_soil = soilCableNumber.getSelectedItem().toString();
                SSpacing_soil = soilSpace.getSelectedItem().toString();
                SInstallationMethod_soil = soilInstallationMethod.getSelectedItem().toString();
                SDepth_soil = depth.getSelectedItem().toString();
                SNature_soil = soilNature.getSelectedItem().toString();
                SCablesInTray_air = airCableNumber.getSelectedItem().toString();
                SNumberOfTray_air = airTrayNumber.getSelectedItem().toString();
                SInstallationMethod_air = airInstallationMethod.getSelectedItem().toString();
                SNatureOfSoil_1p = soilNature1p.getSelectedItem().toString();


                setContentView(R.layout.activity_main3);


            }
        });

        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IVoltage = Integer.valueOf(voltage.getText().toString());
                ICurrent = Integer.valueOf(current.getText().toString());
                DVoltageDrop = Double.valueOf(voltage_drop.getText().toString());
                ILength = Integer.valueOf(length.getText().toString());
                DPowerFactor = Double.valueOf(power_factor.getText().toString());
                IShortCircuit = Integer.valueOf(short_circuit.getText().toString());

                calculate();
                setContentView(R.layout.activity_main4);
            }
        });

        back4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_main3);
            }
        });

        back3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_main2);
            }
        });

        back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_main);
            }
        });


    }

    public double tempCorrectionFactor(){
        double t = (double) temperature.get(SInstallation).get(SInsulationMaterial).get(SAmbientTemperature);
        return t;
    }

    public double soilThermalCorrectionFactor(){
        double d = 0.0;
        if (SPhases.equals(ONE_PHASE)){
            d = natureOfSoil.get(SNatureOfSoil_1p);
        }
        else if (SPhases.equals(THREE_PHASE)){
            d = natureOfSoil.get(SNature_soil);
        }
        return d;
    }

    public double soilDepthCorrectionFactor(){
        double d = (double) depthOfLaying.get(SInstallationMethod_soil).get(SNumber_Cores);
        return d;
    }

    public double soilInstallationCorrectionFactor(){
        double d = installationMethod_soil.get(SNumber_Cores).get(SInstallationMethod_soil).get(SSpacing_soil).get(SNumberOfCables_soil);

        return d;

    }
    public double airInstallationCorrectionFactor(){
        double d = installationMethod_air.get(SNumber_Cores).get(SInstallationMethod_air).get(SNumberOfTray_air).get(SCablesInTray_air);
        return d;
    }



    public void calculate() {
    }

    public String getCrossSection(double entry){

        int value = (int) Math.round(entry);
        int index = 0;

        Set<Integer> keys = currentCapacity.get(SNumber_Cores).get(SType).get(SInsulationMaterial).get(step1).get(step2).keySet();
        List<Integer> list = new ArrayList<>(keys);

        for (Integer k:list) {

            if(value>k){
                index = list.indexOf(k) + 1;
                break;
            }
        }

        // TODO implement division for runs

        return crossSections.get(index);
    }

    public void divide(){

    }

    public void putValues(){

        crossSections.add("16");
        crossSections.add("25");
        crossSections.add("35");
        crossSections.add("50");
        crossSections.add("70");
        crossSections.add("95");
        crossSections.add("120");
        crossSections.add("150");
        crossSections.add("185");
        crossSections.add("240");
        crossSections.add("300");
        crossSections.add("400");


        resistance.put("16" , 1.47);
        resistance.put("25" , 0.927);
        resistance.put("35" , 0.68);
        resistance.put("50" , 0.494);
        resistance.put("70" , 0.342);
        resistance.put("95" , 0.247);
        resistance.put("120" , 0.196);
        resistance.put("150" , 0.159);
        resistance.put("185" , 0.128);
        resistance.put("240" , 0.0984);
        resistance.put("300" , 0.0984); //TODO change
        resistance.put("400" , 0.0984); //TODO change

        reactance.put("16" , 0.11);
        reactance.put("25" , 0.102);
        reactance.put("35" , 0.0972);
        reactance.put("50" , 0.094);
        reactance.put("70" , 0.0891);
        reactance.put("95" , 0.0855);
        reactance.put("120" , 0.0831);
        reactance.put("150" , 0.081);
        reactance.put("185" , 0.0792);
        reactance.put("240" , 0.0773);
        reactance.put("300" , 0.0773); //TODO change
        reactance.put("400" , 0.0773); //TODO change


        temperature.put(AIR , ambientTemp);
        temperature.put(GROUND , groundTemp);

        ambientTemp.put(PVC , ambientTempPVC);
        ambientTemp.put(XLPE , ambientTempXLPE);

        groundTemp.put(PVC , groundTempPVC);
        groundTemp.put(XLPE , groundTempXLPE);

        ambientTempPVC.put("10" ,1.22);
        ambientTempPVC.put("15" ,1.17);
        ambientTempPVC.put("20" ,1.12);
        ambientTempPVC.put("25" ,1.06);
        ambientTempPVC.put("30" ,1.00);
        ambientTempPVC.put("35" ,0.94);
        ambientTempPVC.put("40" ,0.87);
        ambientTempPVC.put("45" ,0.79);
        ambientTempPVC.put("50" ,0.71);
        ambientTempPVC.put("55" ,0.61);
        ambientTempPVC.put("60" ,0.50);
        ambientTempPVC.put("65" ,null);
        ambientTempPVC.put("70" ,null);
        ambientTempPVC.put("75" ,null);
        ambientTempPVC.put("80" ,null);

        ambientTempXLPE.put("10" ,1.15);
        ambientTempXLPE.put("15" ,1.12);
        ambientTempXLPE.put("20" ,1.08);
        ambientTempXLPE.put("25" ,1.04);
        ambientTempXLPE.put("30" ,1.00);
        ambientTempXLPE.put("35" ,0.96);
        ambientTempXLPE.put("40" ,0.91);
        ambientTempXLPE.put("45" ,0.87);
        ambientTempXLPE.put("50" ,0.82);
        ambientTempXLPE.put("55" ,0.76);
        ambientTempXLPE.put("60" ,0.71);
        ambientTempXLPE.put("65" ,0.65);
        ambientTempXLPE.put("70" ,0.58);
        ambientTempXLPE.put("75" ,0.50);
        ambientTempXLPE.put("80" ,0.41);

        groundTempPVC.put("10" ,1.10);
        groundTempPVC.put("15" ,1.05);
        groundTempPVC.put("20" ,1.00);
        groundTempPVC.put("25" ,0.95);
        groundTempPVC.put("30" ,0.89);
        groundTempPVC.put("35" ,0.84);
        groundTempPVC.put("40" ,0.77);
        groundTempPVC.put("45" ,0.71);
        groundTempPVC.put("50" ,0.63);
        groundTempPVC.put("55" ,0.55);
        groundTempPVC.put("60" ,0.45);
        groundTempPVC.put("65" ,null);
        groundTempPVC.put("70" ,null);
        groundTempPVC.put("75" ,null);
        groundTempPVC.put("80" ,null);

        groundTempXLPE.put("10" , 1.07);
        groundTempXLPE.put("15" , 1.04);
        groundTempXLPE.put("20" , 1.00);
        groundTempXLPE.put("25" , 0.96);
        groundTempXLPE.put("30" , 0.93);
        groundTempXLPE.put("35" , 0.89);
        groundTempXLPE.put("40" , 0.85);
        groundTempXLPE.put("45" , 0.80);
        groundTempXLPE.put("50" , 0.76);
        groundTempXLPE.put("55" , 0.71);
        groundTempXLPE.put("60" , 0.65);
        groundTempXLPE.put("65" , 0.60);
        groundTempXLPE.put("70" , 0.53);
        groundTempXLPE.put("75" , 0.46);
        groundTempXLPE.put("80" , 0.38);

        natureOfSoil.put(VERY_WET ,1.21);
        natureOfSoil.put(WET ,1.13);
        natureOfSoil.put(DAMP ,1.05);
        natureOfSoil.put(DRY ,1.00);
        natureOfSoil.put(VERY_DRY ,0.86);

        depthOfLaying.put(DIRECT_BURIED , depth_Direct);
        depthOfLaying.put(CABLE_IN_DUCTS , depth_Duct);

        depth_Direct.put(SINGLE_CORE , depth_Direct_Single);
        depth_Direct.put(THREE_CORE , depth_Direct_Three);

        depth_Duct.put(SINGLE_CORE , depth_Duct_Single);
        depth_Duct.put(THREE_CORE , depth_Duct_Three);

        depth_Direct_Single.put("0.50" , 1.04);
        depth_Direct_Single.put("0.60" , 1.02);
        depth_Direct_Single.put("1.00" , 0.98);
        depth_Direct_Single.put("1.25" , 0.96);
        depth_Direct_Single.put("1.50" , 0.95);
        depth_Direct_Single.put("1.75" , 0.94);
        depth_Direct_Single.put("2.00" , 0.93);
        depth_Direct_Single.put("2.50" , 0.91);
        depth_Direct_Single.put("3.00" , 0.90);

        depth_Direct_Three.put("0.50" , 1.04);
        depth_Direct_Three.put("0.60" , 1.03);
        depth_Direct_Three.put("1.00" , 0.98);
        depth_Direct_Three.put("1.25" , 0.96);
        depth_Direct_Three.put("1.50" , 0.95);
        depth_Direct_Three.put("1.75" , 0.94);
        depth_Direct_Three.put("2.00" , 0.93);
        depth_Direct_Three.put("2.50" , 0.91);
        depth_Direct_Three.put("3.00" , 0.90);

        depth_Duct_Single.put("0.50" , 1.04);
        depth_Duct_Single.put("0.60" , 1.02);
        depth_Duct_Single.put("1.00" , 0.98);
        depth_Duct_Single.put("1.25" , 0.96);
        depth_Duct_Single.put("1.50" , 0.95);
        depth_Duct_Single.put("1.75" , 0.94);
        depth_Duct_Single.put("2.00" , 0.93);
        depth_Duct_Single.put("2.50" , 0.91);
        depth_Duct_Single.put("3.00" , 0.90);

        depth_Duct_Three.put("0.50" , 1.03);
        depth_Duct_Three.put("0.60" , 1.02);
        depth_Duct_Three.put("1.00" , 0.99);
        depth_Duct_Three.put("1.25" , 0.97);
        depth_Duct_Three.put("1.50" , 0.96);
        depth_Duct_Three.put("1.75" , 0.95);
        depth_Duct_Three.put("2.00" , 0.94);
        depth_Duct_Three.put("2.50" , 0.93);
        depth_Duct_Three.put("3.00" , 0.92);

        installationMethod.put(AIR , installationMethod_air);
        installationMethod.put(GROUND , installationMethod_soil);


        installationMethod_air_multi_PHT.put("1" , installationMethod_air_multi_PHT_1t);
        installationMethod_air_multi_PHT.put("2" , installationMethod_air_multi_PHT_2t);

        installationMethod_air_multi_PHS.put("1" , installationMethod_air_multi_PHS_1t);
        installationMethod_air_multi_PHS.put("2" , installationMethod_air_multi_PHS_2t);

        installationMethod_air_multi_PVT.put("1" , installationMethod_air_multi_PVT_1t);
        installationMethod_air_multi_PVT.put("2" , installationMethod_air_multi_PVT_2t);

        installationMethod_air_multi_PVS.put("1" , installationMethod_air_multi_PVS_1t);
        installationMethod_air_multi_PVS.put("2" , installationMethod_air_multi_PVS_2t);

        installationMethod_air_multi_LHT.put("1" , installationMethod_air_multi_LHT_1t);
        installationMethod_air_multi_LHT.put("2" , installationMethod_air_multi_LHT_2t);

        installationMethod_air_multi_LHS.put("1" , installationMethod_air_multi_LHS_1t);
        installationMethod_air_multi_LHS.put("2" , installationMethod_air_multi_LHS_2t);

        installationMethod_air_multi.put(PHT ,installationMethod_air_multi_PHT);
        installationMethod_air_multi.put(PHS ,installationMethod_air_multi_PHS);
        installationMethod_air_multi.put(PVT ,installationMethod_air_multi_PVT);
        installationMethod_air_multi.put(PVS ,installationMethod_air_multi_PVS);
        installationMethod_air_multi.put(LHT ,installationMethod_air_multi_LHT);
        installationMethod_air_multi.put(LHS ,installationMethod_air_multi_LHS);

        installationMethod_air_multi_PHT_1t.put("1" , 1.00);
        installationMethod_air_multi_PHT_1t.put("2" , 0.88);
        installationMethod_air_multi_PHT_1t.put("3" , 0.82);
        installationMethod_air_multi_PHT_1t.put("4" , 0.79);
        installationMethod_air_multi_PHT_1t.put("6" , 0.76);

        installationMethod_air_multi_PHT_2t.put("1" , 1.00);
        installationMethod_air_multi_PHT_2t.put("2" , 0.87);
        installationMethod_air_multi_PHT_2t.put("3" , 0.80);
        installationMethod_air_multi_PHT_2t.put("4" , 0.77);
        installationMethod_air_multi_PHT_2t.put("6" , 0.73);

        installationMethod_air_multi_PHS_1t.put("1" , 1.00);
        installationMethod_air_multi_PHS_1t.put("2" , 1.00);
        installationMethod_air_multi_PHS_1t.put("3" , 0.98);
        installationMethod_air_multi_PHS_1t.put("4" , 0.95);
        installationMethod_air_multi_PHS_1t.put("6" , 0.91);

        installationMethod_air_multi_PHS_2t.put("1" , 1.00);
        installationMethod_air_multi_PHS_2t.put("2" , 0.99);
        installationMethod_air_multi_PHS_2t.put("3" , 0.96);
        installationMethod_air_multi_PHS_2t.put("4" , 0.92);
        installationMethod_air_multi_PHS_2t.put("6" , 0.87);

        installationMethod_air_multi_PVT_1t.put("1" , 1.00);
        installationMethod_air_multi_PVT_1t.put("2" , 0.88);
        installationMethod_air_multi_PVT_1t.put("3" , 0.82);
        installationMethod_air_multi_PVT_1t.put("4" , 0.78);
        installationMethod_air_multi_PVT_1t.put("6" , 0.73);

        installationMethod_air_multi_PVT_2t.put("1" , 1.00);
        installationMethod_air_multi_PVT_2t.put("2" , 0.88);
        installationMethod_air_multi_PVT_2t.put("3" , 0.81);
        installationMethod_air_multi_PVT_2t.put("4" , 0.76);
        installationMethod_air_multi_PVT_2t.put("6" , 0.71);

        installationMethod_air_multi_PVS_1t.put("1" , 1.00);
        installationMethod_air_multi_PVS_1t.put("2" , 0.91);
        installationMethod_air_multi_PVS_1t.put("3" , 0.89);
        installationMethod_air_multi_PVS_1t.put("4" , 0.88);
        installationMethod_air_multi_PVS_1t.put("6" , 0.87);

        installationMethod_air_multi_PVS_2t.put("1" , 1.00);
        installationMethod_air_multi_PVS_2t.put("2" , 0.91);
        installationMethod_air_multi_PVS_2t.put("3" , 0.88);
        installationMethod_air_multi_PVS_2t.put("4" , 0.87);
        installationMethod_air_multi_PVS_2t.put("6" , 0.85);

        installationMethod_air_single_LHT_1t.put("1" , 1.00);
        installationMethod_air_single_LHT_1t.put("2" , 0.87);
        installationMethod_air_single_LHT_1t.put("3" , 0.82);
        installationMethod_air_single_LHT_1t.put("4" , 0.80);
        installationMethod_air_single_LHT_1t.put("6" , 0.79);

        installationMethod_air_single_LHT_2t.put("1" , 1.00);
        installationMethod_air_single_LHT_2t.put("2" , 0.86);
        installationMethod_air_single_LHT_2t.put("3" , 0.80);
        installationMethod_air_single_LHT_2t.put("4" , 0.78);
        installationMethod_air_single_LHT_2t.put("6" , 0.76);

        installationMethod_air_single_LHS_1t.put("1" , 1.00);
        installationMethod_air_single_LHS_1t.put("2" , 1.00);
        installationMethod_air_single_LHS_1t.put("3" , 1.00);
        installationMethod_air_single_LHS_1t.put("4" , 1.00);
        installationMethod_air_single_LHS_1t.put("6" , 1.00);

        installationMethod_air_single_LHS_2t.put("1" , 1.00);
        installationMethod_air_single_LHS_2t.put("2" , 0.99);
        installationMethod_air_single_LHS_2t.put("3" , 0.98);
        installationMethod_air_single_LHS_2t.put("4" , 0.97);
        installationMethod_air_single_LHS_2t.put("6" , 0.96);


        installationMethod_air_single_PHT.put("1" , installationMethod_air_single_PHT_1t);
        installationMethod_air_single_PHT.put("2" , installationMethod_air_single_PHT_2t);

        installationMethod_air_single_PHS.put("1" , installationMethod_air_single_PHS_1t);
        installationMethod_air_single_PHS.put("2" , installationMethod_air_single_PHS_2t);

        installationMethod_air_single_PVT.put("1" , installationMethod_air_single_PVT_1t);
        installationMethod_air_single_PVT.put("2" , installationMethod_air_single_PVT_2t);

        installationMethod_air_single_PVS.put("1" , installationMethod_air_single_PVS_1t);
        installationMethod_air_single_PVS.put("2" , installationMethod_air_single_PVS_2t);

        installationMethod_air_single_LHT.put("1" , installationMethod_air_single_LHT_1t);
        installationMethod_air_single_LHT.put("2" , installationMethod_air_single_LHT_2t);

        installationMethod_air_single_LHS.put("1" , installationMethod_air_single_LHS_1t);
        installationMethod_air_single_LHS.put("2" , installationMethod_air_single_LHS_2t);

        installationMethod_air_single.put(PHT ,installationMethod_air_single_PHT);
        installationMethod_air_single.put(PHS ,installationMethod_air_single_PHS);
        installationMethod_air_single.put(PVT ,installationMethod_air_single_PVT);
        installationMethod_air_single.put(PVS ,installationMethod_air_single_PVS);
        installationMethod_air_single.put(LHT ,installationMethod_air_single_LHT);
        installationMethod_air_single.put(LHS ,installationMethod_air_single_LHS);

        installationMethod_air.put(SINGLE_CORE , installationMethod_air_single);
        installationMethod_air.put(THREE_CORE , installationMethod_air_multi);


        installationMethod_soil.put(SINGLE_CORE , installationMethod_soil_single);
        installationMethod_soil.put(THREE_CORE , installationMethod_soil_multi);

        installationMethod_soil_single.put(DIRECT_BURIED , installationMethod_soil_single_direct);
        installationMethod_soil_single.put(CABLE_IN_DUCTS , installationMethod_soil_single_duct);

        installationMethod_soil_multi.put(DIRECT_BURIED , installationMethod_soil_multi_direct);
        installationMethod_soil_multi.put(CABLE_IN_DUCTS , installationMethod_soil_multi_duct);

        installationMethod_soil_single_direct.put(TOUCHING ,installationMethod_soil_single_direct_touching);
        installationMethod_soil_single_direct.put("200" ,installationMethod_soil_single_direct_200);
        installationMethod_soil_single_direct.put("400" ,installationMethod_soil_single_direct_400);
        installationMethod_soil_single_direct.put("600" ,installationMethod_soil_single_direct_600);
        installationMethod_soil_single_direct.put("800" ,installationMethod_soil_single_direct_800);

        installationMethod_soil_single_duct.put(TOUCHING ,installationMethod_soil_single_duct_touching);
        installationMethod_soil_single_duct.put("200"    ,installationMethod_soil_single_duct_200);
        installationMethod_soil_single_duct.put("400"    ,installationMethod_soil_single_duct_400);
        installationMethod_soil_single_duct.put("600"    ,installationMethod_soil_single_duct_600);
        installationMethod_soil_single_duct.put("800"    ,installationMethod_soil_single_duct_800);

        installationMethod_soil_multi_duct.put(TOUCHING ,installationMethod_soil_multi_duct_touching);
        installationMethod_soil_multi_duct.put("200"    ,installationMethod_soil_multi_duct_200);
        installationMethod_soil_multi_duct.put("400"    ,installationMethod_soil_multi_duct_400);
        installationMethod_soil_multi_duct.put("600"    ,installationMethod_soil_multi_duct_600);
        installationMethod_soil_multi_duct.put("800"    ,installationMethod_soil_multi_duct_800);

        installationMethod_soil_multi_direct.put(TOUCHING ,installationMethod_soil_multi_direct_touching);
        installationMethod_soil_multi_direct.put("200"    ,installationMethod_soil_multi_direct_200);
        installationMethod_soil_multi_direct.put("400"    ,installationMethod_soil_multi_direct_400);
        installationMethod_soil_multi_direct.put("600"    ,installationMethod_soil_multi_direct_600);
        installationMethod_soil_multi_direct.put("800"    ,installationMethod_soil_multi_direct_800);


        installationMethod_soil_single_duct_touching.put("2" , 0.78);
        installationMethod_soil_single_duct_touching.put("3" , 0.66);
        installationMethod_soil_single_duct_touching.put("4" , 0.59);
        installationMethod_soil_single_duct_touching.put("5" , 0.55);
        installationMethod_soil_single_duct_touching.put("6" , 0.51);
        installationMethod_soil_single_duct_touching.put("7" , 0.48);
        installationMethod_soil_single_duct_touching.put("8" , 0.46);
        installationMethod_soil_single_duct_touching.put("9" , 0.44);

        installationMethod_soil_single_duct_200.put("2" , 0.85);
        installationMethod_soil_single_duct_200.put("3" , 0.75);
        installationMethod_soil_single_duct_200.put("4" , 0.70);
        installationMethod_soil_single_duct_200.put("5" , 0.66);
        installationMethod_soil_single_duct_200.put("6" , 0.64);
        installationMethod_soil_single_duct_200.put("7" , 0.61);
        installationMethod_soil_single_duct_200.put("8" , 0.60);
        installationMethod_soil_single_duct_200.put("9" , 0.58);

        installationMethod_soil_single_duct_400.put("2" , 0.89);
        installationMethod_soil_single_duct_400.put("3" , 0.81);
        installationMethod_soil_single_duct_400.put("4" , 0.77);
        installationMethod_soil_single_duct_400.put("5" , 0.74);
        installationMethod_soil_single_duct_400.put("6" , 0.72);
        installationMethod_soil_single_duct_400.put("7" , 0.71);
        installationMethod_soil_single_duct_400.put("8" , 0.70);
        installationMethod_soil_single_duct_400.put("9" , 0.69);

        installationMethod_soil_single_duct_600.put("2" , 0.91);
        installationMethod_soil_single_duct_600.put("3" , 0.85);
        installationMethod_soil_single_duct_600.put("4" , 0.82);
        installationMethod_soil_single_duct_600.put("5" , 0.80);
        installationMethod_soil_single_duct_600.put("6" , 0.78);
        installationMethod_soil_single_duct_600.put("7" , 0.77);
        installationMethod_soil_single_duct_600.put("8" , 0.76);
        installationMethod_soil_single_duct_600.put("9" , 0.76);

        installationMethod_soil_single_duct_800.put("2" , 0.93);
        installationMethod_soil_single_duct_800.put("3" , 0.88);
        installationMethod_soil_single_duct_800.put("4" , 0.86);
        installationMethod_soil_single_duct_800.put("5" , 0.84);
        installationMethod_soil_single_duct_800.put("6" , 0.83);
        installationMethod_soil_single_duct_800.put("7" , 0.82);
        installationMethod_soil_single_duct_800.put("8" , null);
        installationMethod_soil_single_duct_800.put("9" , null);

        installationMethod_soil_multi_duct_touching.put("2" , 0.85);
        installationMethod_soil_multi_duct_touching.put("3" , 0.75);
        installationMethod_soil_multi_duct_touching.put("4" , 0.69);
        installationMethod_soil_multi_duct_touching.put("5" , 0.65);
        installationMethod_soil_multi_duct_touching.put("6" , 0.62);
        installationMethod_soil_multi_duct_touching.put("7" , 0.59);
        installationMethod_soil_multi_duct_touching.put("8" , 0.57);
        installationMethod_soil_multi_duct_touching.put("9" , 0.55);

        installationMethod_soil_multi_duct_200.put("2" , 0.88);
        installationMethod_soil_multi_duct_200.put("3" , 0.80);
        installationMethod_soil_multi_duct_200.put("4" , 0.75);
        installationMethod_soil_multi_duct_200.put("5" , 0.72);
        installationMethod_soil_multi_duct_200.put("6" , 0.69);
        installationMethod_soil_multi_duct_200.put("7" , 0.67);
        installationMethod_soil_multi_duct_200.put("8" , 0.65);
        installationMethod_soil_multi_duct_200.put("9" , 0.64);

        installationMethod_soil_multi_duct_400.put("2" , 0.92);
        installationMethod_soil_multi_duct_400.put("3" , 0.85);
        installationMethod_soil_multi_duct_400.put("4" , 0.82);
        installationMethod_soil_multi_duct_400.put("5" , 0.79);
        installationMethod_soil_multi_duct_400.put("6" , 0.77);
        installationMethod_soil_multi_duct_400.put("7" , 0.76);
        installationMethod_soil_multi_duct_400.put("8" , 0.75);
        installationMethod_soil_multi_duct_400.put("9" , 0.74);

        installationMethod_soil_multi_duct_600.put("2" , 0.94);
        installationMethod_soil_multi_duct_600.put("3" , 0.88);
        installationMethod_soil_multi_duct_600.put("4" , 0.86);
        installationMethod_soil_multi_duct_600.put("5" , 0.84);
        installationMethod_soil_multi_duct_600.put("6" , 0.83);
        installationMethod_soil_multi_duct_600.put("7" , 0.82);
        installationMethod_soil_multi_duct_600.put("8" , 0.81);
        installationMethod_soil_multi_duct_600.put("9" , 0.80);

        installationMethod_soil_multi_duct_800.put("2" , 0.95);
        installationMethod_soil_multi_duct_800.put("3" , 0.91);
        installationMethod_soil_multi_duct_800.put("4" , 0.89);
        installationMethod_soil_multi_duct_800.put("5" , 0.87);
        installationMethod_soil_multi_duct_800.put("6" , 0.87);
        installationMethod_soil_multi_duct_800.put("7" , 0.86);
        installationMethod_soil_multi_duct_800.put("8" , null);
        installationMethod_soil_multi_duct_800.put("9" , null);


        installationMethod_soil_single_direct_touching.put("2" , 0.73);
        installationMethod_soil_single_direct_touching.put("3" , 0.60);
        installationMethod_soil_single_direct_touching.put("4" , 0.54);
        installationMethod_soil_single_direct_touching.put("5" , 0.49);
        installationMethod_soil_single_direct_touching.put("6" , 0.46);
        installationMethod_soil_single_direct_touching.put("7" , 0.43);
        installationMethod_soil_single_direct_touching.put("8" , 0.41);
        installationMethod_soil_single_direct_touching.put("9" , 0.39);

        installationMethod_soil_single_direct_200.put("2" , 0.83);
        installationMethod_soil_single_direct_200.put("3" , 0.73);
        installationMethod_soil_single_direct_200.put("4" , 0.68);
        installationMethod_soil_single_direct_200.put("5" , 0.63);
        installationMethod_soil_single_direct_200.put("6" , 0.61);
        installationMethod_soil_single_direct_200.put("7" , 0.58);
        installationMethod_soil_single_direct_200.put("8" , 0.57);
        installationMethod_soil_single_direct_200.put("9" , 0.55);

        installationMethod_soil_single_direct_400.put("2" , 0.88);
        installationMethod_soil_single_direct_400.put("3" , 0.79);
        installationMethod_soil_single_direct_400.put("4" , 0.75);
        installationMethod_soil_single_direct_400.put("5" , 0.72);
        installationMethod_soil_single_direct_400.put("6" , 0.70);
        installationMethod_soil_single_direct_400.put("7" , 0.68);
        installationMethod_soil_single_direct_400.put("8" , 0.67);
        installationMethod_soil_single_direct_400.put("9" , 0.66);

        installationMethod_soil_single_direct_600.put("2" , 0.90);
        installationMethod_soil_single_direct_600.put("3" , 0.83);
        installationMethod_soil_single_direct_600.put("4" , 0.80);
        installationMethod_soil_single_direct_600.put("5" , 0.78);
        installationMethod_soil_single_direct_600.put("6" , 0.76);
        installationMethod_soil_single_direct_600.put("7" , 0.75);
        installationMethod_soil_single_direct_600.put("8" , 0.74);
        installationMethod_soil_single_direct_600.put("9" , 0.73);

        installationMethod_soil_single_direct_800.put("2" , 0.92);
        installationMethod_soil_single_direct_800.put("3" , 0.86);
        installationMethod_soil_single_direct_800.put("4" , 0.84);
        installationMethod_soil_single_direct_800.put("5" , 0.82);
        installationMethod_soil_single_direct_800.put("6" , 0.81);
        installationMethod_soil_single_direct_800.put("7" , 0.80);
        installationMethod_soil_single_direct_800.put("8" , null);
        installationMethod_soil_single_direct_800.put("9" , null);


        installationMethod_soil_multi_direct_touching.put("2" , 0.80);
        installationMethod_soil_multi_direct_touching.put("3" , 0.69);
        installationMethod_soil_multi_direct_touching.put("4" , 0.62);
        installationMethod_soil_multi_direct_touching.put("5" , 0.57);
        installationMethod_soil_multi_direct_touching.put("6" , 0.54);
        installationMethod_soil_multi_direct_touching.put("7" , 0.51);
        installationMethod_soil_multi_direct_touching.put("8" , 0.49);
        installationMethod_soil_multi_direct_touching.put("9" , 0.47);

        installationMethod_soil_multi_direct_200.put("2" , 0.86);
        installationMethod_soil_multi_direct_200.put("3" , 0.77);
        installationMethod_soil_multi_direct_200.put("4" , 0.72);
        installationMethod_soil_multi_direct_200.put("5" , 0.68);
        installationMethod_soil_multi_direct_200.put("6" , 0.65);
        installationMethod_soil_multi_direct_200.put("7" , 0.63);
        installationMethod_soil_multi_direct_200.put("8" , 0.61);
        installationMethod_soil_multi_direct_200.put("9" , 0.60);

        installationMethod_soil_multi_direct_400.put("2" , 0.90);
        installationMethod_soil_multi_direct_400.put("3" , 0.82);
        installationMethod_soil_multi_direct_400.put("4" , 0.79);
        installationMethod_soil_multi_direct_400.put("5" , 0.76);
        installationMethod_soil_multi_direct_400.put("6" , 0.74);
        installationMethod_soil_multi_direct_400.put("7" , 0.72);
        installationMethod_soil_multi_direct_400.put("8" , 0.71);
        installationMethod_soil_multi_direct_400.put("9" , 0.70);

        installationMethod_soil_multi_direct_600.put("2" , 0.92);
        installationMethod_soil_multi_direct_600.put("3" , 0.86);
        installationMethod_soil_multi_direct_600.put("4" , 0.83);
        installationMethod_soil_multi_direct_600.put("5" , 0.81);
        installationMethod_soil_multi_direct_600.put("6" , 0.80);
        installationMethod_soil_multi_direct_600.put("7" , 0.78);
        installationMethod_soil_multi_direct_600.put("8" , 0.78);
        installationMethod_soil_multi_direct_600.put("9" , 0.77);

        installationMethod_soil_multi_direct_800.put("2" , 0.94);
        installationMethod_soil_multi_direct_800.put("3" , 0.89);
        installationMethod_soil_multi_direct_800.put("4" , 0.87);
        installationMethod_soil_multi_direct_800.put("5" , 0.85);
        installationMethod_soil_multi_direct_800.put("6" , 0.84);
        installationMethod_soil_multi_direct_800.put("7" , 0.83);
        installationMethod_soil_multi_direct_800.put("8" , null);
        installationMethod_soil_multi_direct_800.put("9" , null);

        currentCapacity_single_cooper_XLPE_direct_trefoil.put(109 , "16");
        currentCapacity_single_cooper_XLPE_direct_trefoil.put(140 , "25");
        currentCapacity_single_cooper_XLPE_direct_trefoil.put(466 , "35");
        currentCapacity_single_cooper_XLPE_direct_trefoil.put(196 , "50");
        currentCapacity_single_cooper_XLPE_direct_trefoil.put(239 , "70");
        currentCapacity_single_cooper_XLPE_direct_trefoil.put(285 , "95");
        currentCapacity_single_cooper_XLPE_direct_trefoil.put(323 , "120");
        currentCapacity_single_cooper_XLPE_direct_trefoil.put(361 , "150");
        currentCapacity_single_cooper_XLPE_direct_trefoil.put(406 , "185");
        currentCapacity_single_cooper_XLPE_direct_trefoil.put(469 , "240");
        currentCapacity_single_cooper_XLPE_direct_trefoil.put(526 , "300");
        currentCapacity_single_cooper_XLPE_direct_trefoil.put(590 , "400");

        currentCapacity_single_cooper_XLPE_direct_spaced.put(113 , "16");
        currentCapacity_single_cooper_XLPE_direct_spaced.put(144 , "25");
        currentCapacity_single_cooper_XLPE_direct_spaced.put(172 , "35");
        currentCapacity_single_cooper_XLPE_direct_spaced.put(203 , "50");
        currentCapacity_single_cooper_XLPE_direct_spaced.put(246 , "70");
        currentCapacity_single_cooper_XLPE_direct_spaced.put(293 , "95");
        currentCapacity_single_cooper_XLPE_direct_spaced.put(332 , "120");
        currentCapacity_single_cooper_XLPE_direct_spaced.put(366 , "150");
        currentCapacity_single_cooper_XLPE_direct_spaced.put(410 , "185");
        currentCapacity_single_cooper_XLPE_direct_spaced.put(470 , "240");
        currentCapacity_single_cooper_XLPE_direct_spaced.put(524 , "300");
        currentCapacity_single_cooper_XLPE_direct_spaced.put(572 , "400");

        currentCapacity_single_cooper_XLPE_duct_trefoil.put(103 , "16");
        currentCapacity_single_cooper_XLPE_duct_trefoil.put(132 , "25");
        currentCapacity_single_cooper_XLPE_duct_trefoil.put(157 , "35");
        currentCapacity_single_cooper_XLPE_duct_trefoil.put(186 , "50");
        currentCapacity_single_cooper_XLPE_duct_trefoil.put(227 , "70");
        currentCapacity_single_cooper_XLPE_duct_trefoil.put(271 , "95");
        currentCapacity_single_cooper_XLPE_duct_trefoil.put(308 , "120");
        currentCapacity_single_cooper_XLPE_duct_trefoil.put(343 , "150");
        currentCapacity_single_cooper_XLPE_duct_trefoil.put(387 , "185");
        currentCapacity_single_cooper_XLPE_duct_trefoil.put(447 , "240");
        currentCapacity_single_cooper_XLPE_duct_trefoil.put(504 , "300");
        currentCapacity_single_cooper_XLPE_duct_trefoil.put(564 , "400");

        currentCapacity_single_cooper_XLPE_duct_touching.put(104 , "16");
        currentCapacity_single_cooper_XLPE_duct_touching.put(133 , "25");
        currentCapacity_single_cooper_XLPE_duct_touching.put(159 , "35");
        currentCapacity_single_cooper_XLPE_duct_touching.put(188 , "50");
        currentCapacity_single_cooper_XLPE_duct_touching.put(229 , "70");
        currentCapacity_single_cooper_XLPE_duct_touching.put(274 , "95");
        currentCapacity_single_cooper_XLPE_duct_touching.put(311 , "120");
        currentCapacity_single_cooper_XLPE_duct_touching.put(347 , "150");
        currentCapacity_single_cooper_XLPE_duct_touching.put(391 , "185");
        currentCapacity_single_cooper_XLPE_duct_touching.put(453 , "240");
        currentCapacity_single_cooper_XLPE_duct_touching.put(510 , "300");
        currentCapacity_single_cooper_XLPE_duct_touching.put(571 , "400");

        currentCapacity_single_cooper_XLPE_air_trefoil.put(125 , "16");
        currentCapacity_single_cooper_XLPE_air_trefoil.put(163 , "25");
        currentCapacity_single_cooper_XLPE_air_trefoil.put(198 , "35");
        currentCapacity_single_cooper_XLPE_air_trefoil.put(238 , "50");
        currentCapacity_single_cooper_XLPE_air_trefoil.put(296 , "70");
        currentCapacity_single_cooper_XLPE_air_trefoil.put(361 , "95");
        currentCapacity_single_cooper_XLPE_air_trefoil.put(417 , "120");
        currentCapacity_single_cooper_XLPE_air_trefoil.put(473 , "150");
        currentCapacity_single_cooper_XLPE_air_trefoil.put(543 , "185");
        currentCapacity_single_cooper_XLPE_air_trefoil.put(641 , "240");
        currentCapacity_single_cooper_XLPE_air_trefoil.put(735 , "300");
        currentCapacity_single_cooper_XLPE_air_trefoil.put(845 , "400");

        currentCapacity_single_cooper_XLPE_air_touching.put(128 , "16");
        currentCapacity_single_cooper_XLPE_air_touching.put(167 , "25");
        currentCapacity_single_cooper_XLPE_air_touching.put(203 , "35");
        currentCapacity_single_cooper_XLPE_air_touching.put(243 , "50");
        currentCapacity_single_cooper_XLPE_air_touching.put(303 , "70");
        currentCapacity_single_cooper_XLPE_air_touching.put(369 , "95");
        currentCapacity_single_cooper_XLPE_air_touching.put(426 , "120");
        currentCapacity_single_cooper_XLPE_air_touching.put(481 , "150");
        currentCapacity_single_cooper_XLPE_air_touching.put(550 , "185");
        currentCapacity_single_cooper_XLPE_air_touching.put(647 , "240");
        currentCapacity_single_cooper_XLPE_air_touching.put(739 , "300");
        currentCapacity_single_cooper_XLPE_air_touching.put(837 , "400");

        currentCapacity_single_cooper_XLPE_air_spaced.put(150 , "16");
        currentCapacity_single_cooper_XLPE_air_spaced.put(196 , "25");
        currentCapacity_single_cooper_XLPE_air_spaced.put(238 , "35");
        currentCapacity_single_cooper_XLPE_air_spaced.put(286 , "50");
        currentCapacity_single_cooper_XLPE_air_spaced.put(356 , "70");
        currentCapacity_single_cooper_XLPE_air_spaced.put(434 , "95");
        currentCapacity_single_cooper_XLPE_air_spaced.put(500 , "120");
        currentCapacity_single_cooper_XLPE_air_spaced.put(559 , "150");
        currentCapacity_single_cooper_XLPE_air_spaced.put(637 , "185");
        currentCapacity_single_cooper_XLPE_air_spaced.put(745 , "240");
        currentCapacity_single_cooper_XLPE_air_spaced.put(846 , "300");
        currentCapacity_single_cooper_XLPE_air_spaced.put(938 , "400");




        currentCapacity_single_aluminium_XLPE_direct_trefoil.put(84 , "16");
        currentCapacity_single_aluminium_XLPE_direct_trefoil.put(108 , "25");
        currentCapacity_single_aluminium_XLPE_direct_trefoil.put(129 , "35");
        currentCapacity_single_aluminium_XLPE_direct_trefoil.put(152 , "50");
        currentCapacity_single_aluminium_XLPE_direct_trefoil.put(186 , "70");
        currentCapacity_single_aluminium_XLPE_direct_trefoil.put(221 , "95");
        currentCapacity_single_aluminium_XLPE_direct_trefoil.put(252 , "120");
        currentCapacity_single_aluminium_XLPE_direct_trefoil.put(281 , "150");
        currentCapacity_single_aluminium_XLPE_direct_trefoil.put(317 , "185");
        currentCapacity_single_aluminium_XLPE_direct_trefoil.put(367 , "240");
        currentCapacity_single_aluminium_XLPE_direct_trefoil.put(414 , "300");
        currentCapacity_single_aluminium_XLPE_direct_trefoil.put(470 , "400");

        currentCapacity_single_aluminium_XLPE_direct_spaced.put(88 , "16");
        currentCapacity_single_aluminium_XLPE_direct_spaced.put(112 , "25");
        currentCapacity_single_aluminium_XLPE_direct_spaced.put(134 , "35");
        currentCapacity_single_aluminium_XLPE_direct_spaced.put(157 , "50");
        currentCapacity_single_aluminium_XLPE_direct_spaced.put(192 , "70");
        currentCapacity_single_aluminium_XLPE_direct_spaced.put(229 , "95");
        currentCapacity_single_aluminium_XLPE_direct_spaced.put(260 , "120");
        currentCapacity_single_aluminium_XLPE_direct_spaced.put(288 , "150");
        currentCapacity_single_aluminium_XLPE_direct_spaced.put(324 , "185");
        currentCapacity_single_aluminium_XLPE_direct_spaced.put(373 , "240");
        currentCapacity_single_aluminium_XLPE_direct_spaced.put(419 , "300");
        currentCapacity_single_aluminium_XLPE_direct_spaced.put(466 , "400");

        currentCapacity_single_aluminium_XLPE_duct_trefoil.put(80 , "16");
        currentCapacity_single_aluminium_XLPE_duct_trefoil.put(102 , "25");
        currentCapacity_single_aluminium_XLPE_duct_trefoil.put(122 , "35");
        currentCapacity_single_aluminium_XLPE_duct_trefoil.put(144 , "50");
        currentCapacity_single_aluminium_XLPE_duct_trefoil.put(176 , "70");
        currentCapacity_single_aluminium_XLPE_duct_trefoil.put(210 , "95");
        currentCapacity_single_aluminium_XLPE_duct_trefoil.put(240 , "120");
        currentCapacity_single_aluminium_XLPE_duct_trefoil.put(267 , "150");
        currentCapacity_single_aluminium_XLPE_duct_trefoil.put(303 , "185");
        currentCapacity_single_aluminium_XLPE_duct_trefoil.put(351 , "240");
        currentCapacity_single_aluminium_XLPE_duct_trefoil.put(397 , "300");
        currentCapacity_single_aluminium_XLPE_duct_trefoil.put(451 , "400");

        currentCapacity_single_aluminium_XLPE_duct_touching.put(81 , "16");
        currentCapacity_single_aluminium_XLPE_duct_touching.put(103 , "25");
        currentCapacity_single_aluminium_XLPE_duct_touching.put(123 , "35");
        currentCapacity_single_aluminium_XLPE_duct_touching.put(146 , "50");
        currentCapacity_single_aluminium_XLPE_duct_touching.put(178 , "70");
        currentCapacity_single_aluminium_XLPE_duct_touching.put(213 , "95");
        currentCapacity_single_aluminium_XLPE_duct_touching.put(242 , "120");
        currentCapacity_single_aluminium_XLPE_duct_touching.put(271 , "150");
        currentCapacity_single_aluminium_XLPE_duct_touching.put(307 , "185");
        currentCapacity_single_aluminium_XLPE_duct_touching.put(356 , "240");
        currentCapacity_single_aluminium_XLPE_duct_touching.put(402 , "300");
        currentCapacity_single_aluminium_XLPE_duct_touching.put(457 , "400");

        currentCapacity_single_aluminium_XLPE_air_trefoil.put(97 , "16");
        currentCapacity_single_aluminium_XLPE_air_trefoil.put(127 , "25");
        currentCapacity_single_aluminium_XLPE_air_trefoil.put(154 , "35");
        currentCapacity_single_aluminium_XLPE_air_trefoil.put(184 , "50");
        currentCapacity_single_aluminium_XLPE_air_trefoil.put(230 , "70");
        currentCapacity_single_aluminium_XLPE_air_trefoil.put(280 , "95");
        currentCapacity_single_aluminium_XLPE_air_trefoil.put(324 , "120");
        currentCapacity_single_aluminium_XLPE_air_trefoil.put(368 , "150");
        currentCapacity_single_aluminium_XLPE_air_trefoil.put(424 , "185");
        currentCapacity_single_aluminium_XLPE_air_trefoil.put(502 , "240");
        currentCapacity_single_aluminium_XLPE_air_trefoil.put(577 , "300");
        currentCapacity_single_aluminium_XLPE_air_trefoil.put(673 , "400");

        currentCapacity_single_aluminium_XLPE_air_touching.put(99 , "16");
        currentCapacity_single_aluminium_XLPE_air_touching.put(130 , "25");
        currentCapacity_single_aluminium_XLPE_air_touching.put(157 , "35");
        currentCapacity_single_aluminium_XLPE_air_touching.put(189, "50");
        currentCapacity_single_aluminium_XLPE_air_touching.put(236 , "70");
        currentCapacity_single_aluminium_XLPE_air_touching.put(287 , "95");
        currentCapacity_single_aluminium_XLPE_air_touching.put(332 , "120");
        currentCapacity_single_aluminium_XLPE_air_touching.put(376 , "150");
        currentCapacity_single_aluminium_XLPE_air_touching.put(432 , "185");
        currentCapacity_single_aluminium_XLPE_air_touching.put(511 , "240");
        currentCapacity_single_aluminium_XLPE_air_touching.put(586 , "300");
        currentCapacity_single_aluminium_XLPE_air_touching.put(676 , "400");

        currentCapacity_single_aluminium_XLPE_air_spaced.put(116 , "16");
        currentCapacity_single_aluminium_XLPE_air_spaced.put(153 , "25");
        currentCapacity_single_aluminium_XLPE_air_spaced.put(185 , "35");
        currentCapacity_single_aluminium_XLPE_air_spaced.put(222 , "50");
        currentCapacity_single_aluminium_XLPE_air_spaced.put(278 , "70");
        currentCapacity_single_aluminium_XLPE_air_spaced.put(338 , "95");
        currentCapacity_single_aluminium_XLPE_air_spaced.put(391 , "120");
        currentCapacity_single_aluminium_XLPE_air_spaced.put(440 , "150");
        currentCapacity_single_aluminium_XLPE_air_spaced.put(504 , "185");
        currentCapacity_single_aluminium_XLPE_air_spaced.put(593 , "240");
        currentCapacity_single_aluminium_XLPE_air_spaced.put(677 , "300");
        currentCapacity_single_aluminium_XLPE_air_spaced.put(769 , "400");





        currentCapacity_single_cooper_EPR_direct_trefoil.put(106 , "16");
        currentCapacity_single_cooper_EPR_direct_trefoil.put(136 , "25");
        currentCapacity_single_cooper_EPR_direct_trefoil.put(162 , "35");
        currentCapacity_single_cooper_EPR_direct_trefoil.put(192 , "50");
        currentCapacity_single_cooper_EPR_direct_trefoil.put(234 , "70");
        currentCapacity_single_cooper_EPR_direct_trefoil.put(280 , "95");
        currentCapacity_single_cooper_EPR_direct_trefoil.put(319 , "120");
        currentCapacity_single_cooper_EPR_direct_trefoil.put(357 , "150");
        currentCapacity_single_cooper_EPR_direct_trefoil.put(403 , "185");
        currentCapacity_single_cooper_EPR_direct_trefoil.put(467 , "240");
        currentCapacity_single_cooper_EPR_direct_trefoil.put(526 , "300");
        currentCapacity_single_cooper_EPR_direct_trefoil.put(597 , "400");

        currentCapacity_single_cooper_EPR_direct_spaced.put(109 , "16");
        currentCapacity_single_cooper_EPR_direct_spaced.put(140 , "25");
        currentCapacity_single_cooper_EPR_direct_spaced.put(167 , "35");
        currentCapacity_single_cooper_EPR_direct_spaced.put(198 , "50");
        currentCapacity_single_cooper_EPR_direct_spaced.put(242 , "70");
        currentCapacity_single_cooper_EPR_direct_spaced.put(289 , "95");
        currentCapacity_single_cooper_EPR_direct_spaced.put(329 , "120");
        currentCapacity_single_cooper_EPR_direct_spaced.put(369 , "150");
        currentCapacity_single_cooper_EPR_direct_spaced.put(417 , "185");
        currentCapacity_single_cooper_EPR_direct_spaced.put(484 , "240");
        currentCapacity_single_cooper_EPR_direct_spaced.put(545 , "300");
        currentCapacity_single_cooper_EPR_direct_spaced.put(618 , "400");

        currentCapacity_single_cooper_EPR_duct_trefoil.put(99 , "16");
        currentCapacity_single_cooper_EPR_duct_trefoil.put(128 , "25");
        currentCapacity_single_cooper_EPR_duct_trefoil.put(153 , "35");
        currentCapacity_single_cooper_EPR_duct_trefoil.put(181 , "50");
        currentCapacity_single_cooper_EPR_duct_trefoil.put(222 , "70");
        currentCapacity_single_cooper_EPR_duct_trefoil.put(266 , "95");
        currentCapacity_single_cooper_EPR_duct_trefoil.put(303 , "120");
        currentCapacity_single_cooper_EPR_duct_trefoil.put(341 , "150");
        currentCapacity_single_cooper_EPR_duct_trefoil.put(386 , "185");
        currentCapacity_single_cooper_EPR_duct_trefoil.put(449 , "240");
        currentCapacity_single_cooper_EPR_duct_trefoil.put(509 , "300");
        currentCapacity_single_cooper_EPR_duct_trefoil.put(580 , "400");

        currentCapacity_single_cooper_EPR_duct_touching.put(100 , "16");
        currentCapacity_single_cooper_EPR_duct_touching.put(129 , "25");
        currentCapacity_single_cooper_EPR_duct_touching.put(154 , "35");
        currentCapacity_single_cooper_EPR_duct_touching.put(183 , "50");
        currentCapacity_single_cooper_EPR_duct_touching.put(224 , "70");
        currentCapacity_single_cooper_EPR_duct_touching.put(269 , "95");
        currentCapacity_single_cooper_EPR_duct_touching.put(306 , "120");
        currentCapacity_single_cooper_EPR_duct_touching.put(344 , "150");
        currentCapacity_single_cooper_EPR_duct_touching.put(390 , "185");
        currentCapacity_single_cooper_EPR_duct_touching.put(454 , "240");
        currentCapacity_single_cooper_EPR_duct_touching.put(515 , "300");
        currentCapacity_single_cooper_EPR_duct_touching.put(588 , "400");

        currentCapacity_single_cooper_EPR_air_trefoil.put(116 , "16");
        currentCapacity_single_cooper_EPR_air_trefoil.put(153 , "25");
        currentCapacity_single_cooper_EPR_air_trefoil.put(186 , "35");
        currentCapacity_single_cooper_EPR_air_trefoil.put(224 , "50");
        currentCapacity_single_cooper_EPR_air_trefoil.put(280 , "70");
        currentCapacity_single_cooper_EPR_air_trefoil.put(343 , "95");
        currentCapacity_single_cooper_EPR_air_trefoil.put(398 , "120");
        currentCapacity_single_cooper_EPR_air_trefoil.put(454 , "150");
        currentCapacity_single_cooper_EPR_air_trefoil.put(522 , "185");
        currentCapacity_single_cooper_EPR_air_trefoil.put(619 , "240");
        currentCapacity_single_cooper_EPR_air_trefoil.put(712 , "300");
        currentCapacity_single_cooper_EPR_air_trefoil.put(825 , "400");

        currentCapacity_single_cooper_EPR_air_touching.put(119 , "16");
        currentCapacity_single_cooper_EPR_air_touching.put(156 , "25");
        currentCapacity_single_cooper_EPR_air_touching.put(190 , "35");
        currentCapacity_single_cooper_EPR_air_touching.put(229 , "50");
        currentCapacity_single_cooper_EPR_air_touching.put(287 , "70");
        currentCapacity_single_cooper_EPR_air_touching.put(352 , "95");
        currentCapacity_single_cooper_EPR_air_touching.put(407 , "120");
        currentCapacity_single_cooper_EPR_air_touching.put(465 , "150");
        currentCapacity_single_cooper_EPR_air_touching.put(534 , "185");
        currentCapacity_single_cooper_EPR_air_touching.put(634 , "240");
        currentCapacity_single_cooper_EPR_air_touching.put(728 , "300");
        currentCapacity_single_cooper_EPR_air_touching.put(843 , "400");

        currentCapacity_single_cooper_EPR_air_spaced.put(138 , "16");
        currentCapacity_single_cooper_EPR_air_spaced.put(181 , "25");
        currentCapacity_single_cooper_EPR_air_spaced.put(221 , "35");
        currentCapacity_single_cooper_EPR_air_spaced.put(266 , "50");
        currentCapacity_single_cooper_EPR_air_spaced.put(334 , "70");
        currentCapacity_single_cooper_EPR_air_spaced.put(409 , "95");
        currentCapacity_single_cooper_EPR_air_spaced.put(474 , "120");
        currentCapacity_single_cooper_EPR_air_spaced.put(540 , "150");
        currentCapacity_single_cooper_EPR_air_spaced.put(621 , "185");
        currentCapacity_single_cooper_EPR_air_spaced.put(736 , "240");
        currentCapacity_single_cooper_EPR_air_spaced.put(843 , "300");
        currentCapacity_single_cooper_EPR_air_spaced.put(977 , "400");



        currentCapacity_single_aluminium_EPR_direct_trefoil.put(82 , "16");
        currentCapacity_single_aluminium_EPR_direct_trefoil.put(105 , "25");
        currentCapacity_single_aluminium_EPR_direct_trefoil.put(126 , "35");
        currentCapacity_single_aluminium_EPR_direct_trefoil.put(149 , "50");
        currentCapacity_single_aluminium_EPR_direct_trefoil.put(182 , "70");
        currentCapacity_single_aluminium_EPR_direct_trefoil.put(217 , "95");
        currentCapacity_single_aluminium_EPR_direct_trefoil.put(247 , "120");
        currentCapacity_single_aluminium_EPR_direct_trefoil.put(277 , "150");
        currentCapacity_single_aluminium_EPR_direct_trefoil.put(314 , "185");
        currentCapacity_single_aluminium_EPR_direct_trefoil.put(364 , "240");
        currentCapacity_single_aluminium_EPR_direct_trefoil.put(411 , "300");
        currentCapacity_single_aluminium_EPR_direct_trefoil.put(471 , "400");

        currentCapacity_single_aluminium_EPR_direct_spaced.put(84 , "16");
        currentCapacity_single_aluminium_EPR_direct_spaced.put(109 , "25");
        currentCapacity_single_aluminium_EPR_direct_spaced.put(130 , "35");
        currentCapacity_single_aluminium_EPR_direct_spaced.put(153 , "50");
        currentCapacity_single_aluminium_EPR_direct_spaced.put(188 , "70");
        currentCapacity_single_aluminium_EPR_direct_spaced.put(224 , "95");
        currentCapacity_single_aluminium_EPR_direct_spaced.put(256 , "120");
        currentCapacity_single_aluminium_EPR_direct_spaced.put(287 , "150");
        currentCapacity_single_aluminium_EPR_direct_spaced.put(325 , "185");
        currentCapacity_single_aluminium_EPR_direct_spaced.put(377 , "240");
        currentCapacity_single_aluminium_EPR_direct_spaced.put(426 , "300");
        currentCapacity_single_aluminium_EPR_direct_spaced.put(487 , "400");

        currentCapacity_single_aluminium_EPR_duct_trefoil.put(77 , "16");
        currentCapacity_single_aluminium_EPR_duct_trefoil.put(99 , "25");
        currentCapacity_single_aluminium_EPR_duct_trefoil.put(118 , "35");
        currentCapacity_single_aluminium_EPR_duct_trefoil.put(140 , "50");
        currentCapacity_single_aluminium_EPR_duct_trefoil.put(172 , "70");
        currentCapacity_single_aluminium_EPR_duct_trefoil.put(206 , "95");
        currentCapacity_single_aluminium_EPR_duct_trefoil.put(235 , "120");
        currentCapacity_single_aluminium_EPR_duct_trefoil.put(264 , "150");
        currentCapacity_single_aluminium_EPR_duct_trefoil.put(300 , "185");
        currentCapacity_single_aluminium_EPR_duct_trefoil.put(350 , "240");
        currentCapacity_single_aluminium_EPR_duct_trefoil.put(397 , "300");
        currentCapacity_single_aluminium_EPR_duct_trefoil.put(456 , "400");

        currentCapacity_single_aluminium_EPR_duct_touching.put(78 , "16");
        currentCapacity_single_aluminium_EPR_duct_touching.put(100 , "25");
        currentCapacity_single_aluminium_EPR_duct_touching.put(120 , "35");
        currentCapacity_single_aluminium_EPR_duct_touching.put(142 , "50");
        currentCapacity_single_aluminium_EPR_duct_touching.put(174 , "70");
        currentCapacity_single_aluminium_EPR_duct_touching.put(208 , "95");
        currentCapacity_single_aluminium_EPR_duct_touching.put(238 , "120");
        currentCapacity_single_aluminium_EPR_duct_touching.put(267 , "150");
        currentCapacity_single_aluminium_EPR_duct_touching.put(303 , "185");
        currentCapacity_single_aluminium_EPR_duct_touching.put(354, "240");
        currentCapacity_single_aluminium_EPR_duct_touching.put(401 , "300");
        currentCapacity_single_aluminium_EPR_duct_touching.put(462 , "400");

        currentCapacity_single_aluminium_EPR_air_trefoil.put(90 , "16");
        currentCapacity_single_aluminium_EPR_air_trefoil.put(119 , "25");
        currentCapacity_single_aluminium_EPR_air_trefoil.put(144 , "35");
        currentCapacity_single_aluminium_EPR_air_trefoil.put(174 , "50");
        currentCapacity_single_aluminium_EPR_air_trefoil.put(218 , "70");
        currentCapacity_single_aluminium_EPR_air_trefoil.put(266 , "95");
        currentCapacity_single_aluminium_EPR_air_trefoil.put(309 , "120");
        currentCapacity_single_aluminium_EPR_air_trefoil.put(352 , "150");
        currentCapacity_single_aluminium_EPR_air_trefoil.put(406 , "185");
        currentCapacity_single_aluminium_EPR_air_trefoil.put(483 , "240");
        currentCapacity_single_aluminium_EPR_air_trefoil.put(556 , "300");
        currentCapacity_single_aluminium_EPR_air_trefoil.put(651 , "400");

        currentCapacity_single_aluminium_EPR_air_touching.put(92 , "16");
        currentCapacity_single_aluminium_EPR_air_touching.put(121 , "25");
        currentCapacity_single_aluminium_EPR_air_touching.put(147 , "35");
        currentCapacity_single_aluminium_EPR_air_touching.put(178 , "50");
        currentCapacity_single_aluminium_EPR_air_touching.put(223 , "70");
        currentCapacity_single_aluminium_EPR_air_touching.put(273 , "95");
        currentCapacity_single_aluminium_EPR_air_touching.put(317 , "120");
        currentCapacity_single_aluminium_EPR_air_touching.put(361 , "150");
        currentCapacity_single_aluminium_EPR_air_touching.put(417 , "185");
        currentCapacity_single_aluminium_EPR_air_touching.put(495 , "240");
        currentCapacity_single_aluminium_EPR_air_touching.put(570 , "300");
        currentCapacity_single_aluminium_EPR_air_touching.put(667 , "400");

        currentCapacity_single_aluminium_EPR_air_spaced.put(107 , "16");
        currentCapacity_single_aluminium_EPR_air_spaced.put(141 , "25");
        currentCapacity_single_aluminium_EPR_air_spaced.put(171 , "35");
        currentCapacity_single_aluminium_EPR_air_spaced.put(207 , "50");
        currentCapacity_single_aluminium_EPR_air_spaced.put(259 , "70");
        currentCapacity_single_aluminium_EPR_air_spaced.put(317 , "95");
        currentCapacity_single_aluminium_EPR_air_spaced.put(368 , "120");
        currentCapacity_single_aluminium_EPR_air_spaced.put(419 , "150");
        currentCapacity_single_aluminium_EPR_air_spaced.put(484 , "185");
        currentCapacity_single_aluminium_EPR_air_spaced.put(575 , "240");
        currentCapacity_single_aluminium_EPR_air_spaced.put(659 , "300");
        currentCapacity_single_aluminium_EPR_air_spaced.put(770 , "400");




        currentCapacity_multi_cooper_XLPE_unarmoured_direct.put(101 , "16");
        currentCapacity_multi_cooper_XLPE_unarmoured_direct.put(129 , "25");
        currentCapacity_multi_cooper_XLPE_unarmoured_direct.put(153 , "35");
        currentCapacity_multi_cooper_XLPE_unarmoured_direct.put(181 , "50");
        currentCapacity_multi_cooper_XLPE_unarmoured_direct.put(221 , "70");
        currentCapacity_multi_cooper_XLPE_unarmoured_direct.put(262 , "95");
        currentCapacity_multi_cooper_XLPE_unarmoured_direct.put(298 , "120");
        currentCapacity_multi_cooper_XLPE_unarmoured_direct.put(334 , "150");
        currentCapacity_multi_cooper_XLPE_unarmoured_direct.put(377 , "185");
        currentCapacity_multi_cooper_XLPE_unarmoured_direct.put(434 , "240");
        currentCapacity_multi_cooper_XLPE_unarmoured_direct.put(489 , "300");
        currentCapacity_multi_cooper_XLPE_unarmoured_direct.put(553 , "400");

        currentCapacity_multi_cooper_XLPE_unarmoured_duct.put(87 , "16");
        currentCapacity_multi_cooper_XLPE_unarmoured_duct.put(112 , "25");
        currentCapacity_multi_cooper_XLPE_unarmoured_duct.put(133 , "35");
        currentCapacity_multi_cooper_XLPE_unarmoured_duct.put(158 , "50");
        currentCapacity_multi_cooper_XLPE_unarmoured_duct.put(193 , "70");
        currentCapacity_multi_cooper_XLPE_unarmoured_duct.put(231 , "95");
        currentCapacity_multi_cooper_XLPE_unarmoured_duct.put(264 , "120");
        currentCapacity_multi_cooper_XLPE_unarmoured_duct.put(297 , "150");
        currentCapacity_multi_cooper_XLPE_unarmoured_duct.put(336 , "185");
        currentCapacity_multi_cooper_XLPE_unarmoured_duct.put(390 , "240");
        currentCapacity_multi_cooper_XLPE_unarmoured_duct.put(441 , "300");
        currentCapacity_multi_cooper_XLPE_unarmoured_duct.put(501 , "400");

        currentCapacity_multi_cooper_XLPE_unarmoured_air.put(109 , "16");
        currentCapacity_multi_cooper_XLPE_unarmoured_air.put(142 , "25");
        currentCapacity_multi_cooper_XLPE_unarmoured_air.put(170 , "35");
        currentCapacity_multi_cooper_XLPE_unarmoured_air.put(204 , "50");
        currentCapacity_multi_cooper_XLPE_unarmoured_air.put(253 , "70");
        currentCapacity_multi_cooper_XLPE_unarmoured_air.put(304 , "95");
        currentCapacity_multi_cooper_XLPE_unarmoured_air.put(351 , "120");
        currentCapacity_multi_cooper_XLPE_unarmoured_air.put(398 , "150");
        currentCapacity_multi_cooper_XLPE_unarmoured_air.put(455 , "185");
        currentCapacity_multi_cooper_XLPE_unarmoured_air.put(531 , "240");
        currentCapacity_multi_cooper_XLPE_unarmoured_air.put(606 , "300");
        currentCapacity_multi_cooper_XLPE_unarmoured_air.put(696 , "400");

        currentCapacity_multi_cooper_XLPE_armoured_direct.put(101 , "16");
        currentCapacity_multi_cooper_XLPE_armoured_direct.put(129 , "25");
        currentCapacity_multi_cooper_XLPE_armoured_direct.put(154 , "35");
        currentCapacity_multi_cooper_XLPE_armoured_direct.put(181 , "50");
        currentCapacity_multi_cooper_XLPE_armoured_direct.put(220 , "70");
        currentCapacity_multi_cooper_XLPE_armoured_direct.put(263 , "95");
        currentCapacity_multi_cooper_XLPE_armoured_direct.put(298 , "120");
        currentCapacity_multi_cooper_XLPE_armoured_direct.put(332 , "150");
        currentCapacity_multi_cooper_XLPE_armoured_direct.put(374 , "185");
        currentCapacity_multi_cooper_XLPE_armoured_direct.put(431 , "240");
        currentCapacity_multi_cooper_XLPE_armoured_direct.put(482 , "300");
        currentCapacity_multi_cooper_XLPE_armoured_direct.put(541 , "400");

        currentCapacity_multi_cooper_XLPE_armoured_duct.put(88 , "16");
        currentCapacity_multi_cooper_XLPE_armoured_duct.put(112 , "25");
        currentCapacity_multi_cooper_XLPE_armoured_duct.put(134 , "35");
        currentCapacity_multi_cooper_XLPE_armoured_duct.put(158 , "50");
        currentCapacity_multi_cooper_XLPE_armoured_duct.put(194 , "70");
        currentCapacity_multi_cooper_XLPE_armoured_duct.put(232 , "95");
        currentCapacity_multi_cooper_XLPE_armoured_duct.put(264 , "120");
        currentCapacity_multi_cooper_XLPE_armoured_duct.put(296 , "150");
        currentCapacity_multi_cooper_XLPE_armoured_duct.put(335 , "185");
        currentCapacity_multi_cooper_XLPE_armoured_duct.put(387 , "240");
        currentCapacity_multi_cooper_XLPE_armoured_duct.put(435 , "300");
        currentCapacity_multi_cooper_XLPE_armoured_duct.put(492 , "400");

        currentCapacity_multi_cooper_XLPE_armoured_air.put(110 , "16");
        currentCapacity_multi_cooper_XLPE_armoured_air.put(143 , "25");
        currentCapacity_multi_cooper_XLPE_armoured_air.put(172 , "35");
        currentCapacity_multi_cooper_XLPE_armoured_air.put(205 , "50");
        currentCapacity_multi_cooper_XLPE_armoured_air.put(253 , "70");
        currentCapacity_multi_cooper_XLPE_armoured_air.put(307 , "95");
        currentCapacity_multi_cooper_XLPE_armoured_air.put(352 , "120");
        currentCapacity_multi_cooper_XLPE_armoured_air.put(397 , "150");
        currentCapacity_multi_cooper_XLPE_armoured_air.put(453 , "185");
        currentCapacity_multi_cooper_XLPE_armoured_air.put(529 , "240");
        currentCapacity_multi_cooper_XLPE_armoured_air.put(599 , "300");
        currentCapacity_multi_cooper_XLPE_armoured_air.put(683 , "400");




        currentCapacity_multi_aluminium_XLPE_unarmoured_direct.put(78 , "16");
        currentCapacity_multi_aluminium_XLPE_unarmoured_direct.put(100 , "25");
        currentCapacity_multi_aluminium_XLPE_unarmoured_direct.put(119 , "35");
        currentCapacity_multi_aluminium_XLPE_unarmoured_direct.put(140 , "50");
        currentCapacity_multi_aluminium_XLPE_unarmoured_direct.put(171 , "70");
        currentCapacity_multi_aluminium_XLPE_unarmoured_direct.put(203 , "95");
        currentCapacity_multi_aluminium_XLPE_unarmoured_direct.put(232 , "120");
        currentCapacity_multi_aluminium_XLPE_unarmoured_direct.put(260 , "150");
        currentCapacity_multi_aluminium_XLPE_unarmoured_direct.put(294 , "185");
        currentCapacity_multi_aluminium_XLPE_unarmoured_direct.put(340 , "240");
        currentCapacity_multi_aluminium_XLPE_unarmoured_direct.put(384 , "300");
        currentCapacity_multi_aluminium_XLPE_unarmoured_direct.put(438 , "400");

        currentCapacity_multi_aluminium_XLPE_unarmoured_duct.put(67 , "16");
        currentCapacity_multi_aluminium_XLPE_unarmoured_duct.put(87 , "25");
        currentCapacity_multi_aluminium_XLPE_unarmoured_duct.put(103 , "35");
        currentCapacity_multi_aluminium_XLPE_unarmoured_duct.put(122 , "50");
        currentCapacity_multi_aluminium_XLPE_unarmoured_duct.put(150 , "70");
        currentCapacity_multi_aluminium_XLPE_unarmoured_duct.put(179 , "95");
        currentCapacity_multi_aluminium_XLPE_unarmoured_duct.put(205 , "120");
        currentCapacity_multi_aluminium_XLPE_unarmoured_duct.put(231 , "150");
        currentCapacity_multi_aluminium_XLPE_unarmoured_duct.put(262 , "185");
        currentCapacity_multi_aluminium_XLPE_unarmoured_duct.put(305 , "240");
        currentCapacity_multi_aluminium_XLPE_unarmoured_duct.put(346 , "300");
        currentCapacity_multi_aluminium_XLPE_unarmoured_duct.put(398 , "400");

        currentCapacity_multi_aluminium_XLPE_unarmoured_air.put(84 , "16");
        currentCapacity_multi_aluminium_XLPE_unarmoured_air.put(110 , "25");
        currentCapacity_multi_aluminium_XLPE_unarmoured_air.put(132 , "35");
        currentCapacity_multi_aluminium_XLPE_unarmoured_air.put(158 , "50");
        currentCapacity_multi_aluminium_XLPE_unarmoured_air.put(196 , "70");
        currentCapacity_multi_aluminium_XLPE_unarmoured_air.put(236 , "95");
        currentCapacity_multi_aluminium_XLPE_unarmoured_air.put(273 , "120");
        currentCapacity_multi_aluminium_XLPE_unarmoured_air.put(309 , "150");
        currentCapacity_multi_aluminium_XLPE_unarmoured_air.put(355 , "185");
        currentCapacity_multi_aluminium_XLPE_unarmoured_air.put(415 , "240");
        currentCapacity_multi_aluminium_XLPE_unarmoured_air.put(475 , "300");
        currentCapacity_multi_aluminium_XLPE_unarmoured_air.put(552 , "400");

        currentCapacity_multi_aluminium_XLPE_armoured_direct.put(78 , "16");
        currentCapacity_multi_aluminium_XLPE_armoured_direct.put(100 , "25");
        currentCapacity_multi_aluminium_XLPE_armoured_direct.put(119 , "35");
        currentCapacity_multi_aluminium_XLPE_armoured_direct.put(140 , "50");
        currentCapacity_multi_aluminium_XLPE_armoured_direct.put(171 , "70");
        currentCapacity_multi_aluminium_XLPE_armoured_direct.put(204 , "95");
        currentCapacity_multi_aluminium_XLPE_armoured_direct.put(232 , "120");
        currentCapacity_multi_aluminium_XLPE_armoured_direct.put(259 , "150");
        currentCapacity_multi_aluminium_XLPE_armoured_direct.put(293 , "185");
        currentCapacity_multi_aluminium_XLPE_armoured_direct.put(338 , "240");
        currentCapacity_multi_aluminium_XLPE_armoured_direct.put(380 , "300");
        currentCapacity_multi_aluminium_XLPE_armoured_direct.put(432 , "400");

        currentCapacity_multi_aluminium_XLPE_armoured_duct.put(68 , "16");
        currentCapacity_multi_aluminium_XLPE_armoured_duct.put(87 , "25");
        currentCapacity_multi_aluminium_XLPE_armoured_duct.put(104 , "35");
        currentCapacity_multi_aluminium_XLPE_armoured_duct.put(123 , "50");
        currentCapacity_multi_aluminium_XLPE_armoured_duct.put(150 , "70");
        currentCapacity_multi_aluminium_XLPE_armoured_duct.put(180 , "95");
        currentCapacity_multi_aluminium_XLPE_armoured_duct.put(206 , "120");
        currentCapacity_multi_aluminium_XLPE_armoured_duct.put(231 , "150");
        currentCapacity_multi_aluminium_XLPE_armoured_duct.put(262 , "185");
        currentCapacity_multi_aluminium_XLPE_armoured_duct.put(304 , "240");
        currentCapacity_multi_aluminium_XLPE_armoured_duct.put(343 , "300");
        currentCapacity_multi_aluminium_XLPE_armoured_duct.put(393 , "400");

        currentCapacity_multi_aluminium_XLPE_armoured_air.put(85 , "16");
        currentCapacity_multi_aluminium_XLPE_armoured_air.put(111 , "25");
        currentCapacity_multi_aluminium_XLPE_armoured_air.put(133 , "35");
        currentCapacity_multi_aluminium_XLPE_armoured_air.put(159 , "50");
        currentCapacity_multi_aluminium_XLPE_armoured_air.put(196 , "70");
        currentCapacity_multi_aluminium_XLPE_armoured_air.put(238 , "95");
        currentCapacity_multi_aluminium_XLPE_armoured_air.put(274 , "120");
        currentCapacity_multi_aluminium_XLPE_armoured_air.put(309 , "150");
        currentCapacity_multi_aluminium_XLPE_armoured_air.put(354 , "185");
        currentCapacity_multi_aluminium_XLPE_armoured_air.put(415 , "240");
        currentCapacity_multi_aluminium_XLPE_armoured_air.put(472 , "300");
        currentCapacity_multi_aluminium_XLPE_armoured_air.put(545 , "400");





        currentCapacity_multi_cooper_EPR_unarmoured_direct.put(98 , "16");
        currentCapacity_multi_cooper_EPR_unarmoured_direct.put(125 , "25");
        currentCapacity_multi_cooper_EPR_unarmoured_direct.put(150 , "35");
        currentCapacity_multi_cooper_EPR_unarmoured_direct.put(176 , "50");
        currentCapacity_multi_cooper_EPR_unarmoured_direct.put(216 , "70");
        currentCapacity_multi_cooper_EPR_unarmoured_direct.put(258 , "95");
        currentCapacity_multi_cooper_EPR_unarmoured_direct.put(292 , "120");
        currentCapacity_multi_cooper_EPR_unarmoured_direct.put(328 , "150");
        currentCapacity_multi_cooper_EPR_unarmoured_direct.put(371 , "185");
        currentCapacity_multi_cooper_EPR_unarmoured_direct.put(429 , "240");
        currentCapacity_multi_cooper_EPR_unarmoured_direct.put(482 , "300");
        currentCapacity_multi_cooper_EPR_unarmoured_direct.put(545 , "400");

        currentCapacity_multi_cooper_EPR_unarmoured_duct.put(84 , "16");
        currentCapacity_multi_cooper_EPR_unarmoured_duct.put(109 , "25");
        currentCapacity_multi_cooper_EPR_unarmoured_duct.put(130 , "35");
        currentCapacity_multi_cooper_EPR_unarmoured_duct.put(154 , "50");
        currentCapacity_multi_cooper_EPR_unarmoured_duct.put(189 , "70");
        currentCapacity_multi_cooper_EPR_unarmoured_duct.put(227 , "95");
        currentCapacity_multi_cooper_EPR_unarmoured_duct.put(258 , "120");
        currentCapacity_multi_cooper_EPR_unarmoured_duct.put(291 , "150");
        currentCapacity_multi_cooper_EPR_unarmoured_duct.put(330 , "185");
        currentCapacity_multi_cooper_EPR_unarmoured_duct.put(384 , "240");
        currentCapacity_multi_cooper_EPR_unarmoured_duct.put(434 , "300");
        currentCapacity_multi_cooper_EPR_unarmoured_duct.put(494 , "400");

        currentCapacity_multi_cooper_EPR_unarmoured_air.put(104 , "16");
        currentCapacity_multi_cooper_EPR_unarmoured_air.put(135 , "25");
        currentCapacity_multi_cooper_EPR_unarmoured_air.put(164 , "35");
        currentCapacity_multi_cooper_EPR_unarmoured_air.put(195 , "50");
        currentCapacity_multi_cooper_EPR_unarmoured_air.put(243 , "70");
        currentCapacity_multi_cooper_EPR_unarmoured_air.put(296 , "95");
        currentCapacity_multi_cooper_EPR_unarmoured_air.put(339 , "120");
        currentCapacity_multi_cooper_EPR_unarmoured_air.put(385 , "150");
        currentCapacity_multi_cooper_EPR_unarmoured_air.put(441 , "185");
        currentCapacity_multi_cooper_EPR_unarmoured_air.put(519 , "240");
        currentCapacity_multi_cooper_EPR_unarmoured_air.put(590 , "300");
        currentCapacity_multi_cooper_EPR_unarmoured_air.put(678 , "400");

        currentCapacity_multi_cooper_EPR_armoured_direct.put(98 , "16");
        currentCapacity_multi_cooper_EPR_armoured_direct.put(125 , "25");
        currentCapacity_multi_cooper_EPR_armoured_direct.put(150 , "35");
        currentCapacity_multi_cooper_EPR_armoured_direct.put(177 , "50");
        currentCapacity_multi_cooper_EPR_armoured_direct.put(216 , "70");
        currentCapacity_multi_cooper_EPR_armoured_direct.put(257 , "95");
        currentCapacity_multi_cooper_EPR_armoured_direct.put(292 , "120");
        currentCapacity_multi_cooper_EPR_armoured_direct.put(327 , "150");
        currentCapacity_multi_cooper_EPR_armoured_direct.put(368 , "185");
        currentCapacity_multi_cooper_EPR_armoured_direct.put(424 , "240");
        currentCapacity_multi_cooper_EPR_armoured_direct.put(475 , "300");
        currentCapacity_multi_cooper_EPR_armoured_direct.put(534 , "400");

        currentCapacity_multi_cooper_EPR_armoured_duct.put(85 , "16");
        currentCapacity_multi_cooper_EPR_armoured_duct.put(109 , "25");
        currentCapacity_multi_cooper_EPR_armoured_duct.put(131 , "35");
        currentCapacity_multi_cooper_EPR_armoured_duct.put(155 , "50");
        currentCapacity_multi_cooper_EPR_armoured_duct.put(190 , "70");
        currentCapacity_multi_cooper_EPR_armoured_duct.put(227 , "95");
        currentCapacity_multi_cooper_EPR_armoured_duct.put(259 , "120");
        currentCapacity_multi_cooper_EPR_armoured_duct.put(291 , "150");
        currentCapacity_multi_cooper_EPR_armoured_duct.put(328 , "185");
        currentCapacity_multi_cooper_EPR_armoured_duct.put(381 , "240");
        currentCapacity_multi_cooper_EPR_armoured_duct.put(429 , "300");
        currentCapacity_multi_cooper_EPR_armoured_duct.put(485 , "400");

        currentCapacity_multi_cooper_EPR_armoured_air.put(104 , "16");
        currentCapacity_multi_cooper_EPR_armoured_air.put(136 , "25");
        currentCapacity_multi_cooper_EPR_armoured_air.put(164 , "35");
        currentCapacity_multi_cooper_EPR_armoured_air.put(197 , "50");
        currentCapacity_multi_cooper_EPR_armoured_air.put(244 , "70");
        currentCapacity_multi_cooper_EPR_armoured_air.put(296 , "95");
        currentCapacity_multi_cooper_EPR_armoured_air.put(339 , "120");
        currentCapacity_multi_cooper_EPR_armoured_air.put(385 , "150");
        currentCapacity_multi_cooper_EPR_armoured_air.put(439 , "185");
        currentCapacity_multi_cooper_EPR_armoured_air.put(513 , "240");
        currentCapacity_multi_cooper_EPR_armoured_air.put(583 , "300");
        currentCapacity_multi_cooper_EPR_armoured_air.put(666 , "400");






        currentCapacity_multi_aluminium_EPR_unarmoured_direct.put(76 , "16");
        currentCapacity_multi_aluminium_EPR_unarmoured_direct.put(97 , "25");
        currentCapacity_multi_aluminium_EPR_unarmoured_direct.put(116 , "35");
        currentCapacity_multi_aluminium_EPR_unarmoured_direct.put(137 , "50");
        currentCapacity_multi_aluminium_EPR_unarmoured_direct.put(167 , "70");
        currentCapacity_multi_aluminium_EPR_unarmoured_direct.put(200 , "95");
        currentCapacity_multi_aluminium_EPR_unarmoured_direct.put(227 , "120");
        currentCapacity_multi_aluminium_EPR_unarmoured_direct.put(255 , "150");
        currentCapacity_multi_aluminium_EPR_unarmoured_direct.put(289 , "185");
        currentCapacity_multi_aluminium_EPR_unarmoured_direct.put(335 , "240");
        currentCapacity_multi_aluminium_EPR_unarmoured_direct.put(378 , "300");
        currentCapacity_multi_aluminium_EPR_unarmoured_direct.put(432 , "400");

        currentCapacity_multi_aluminium_EPR_unarmoured_duct.put(65 , "16");
        currentCapacity_multi_aluminium_EPR_unarmoured_duct.put(84 , "25");
        currentCapacity_multi_aluminium_EPR_unarmoured_duct.put(101 , "35");
        currentCapacity_multi_aluminium_EPR_unarmoured_duct.put(119 , "50");
        currentCapacity_multi_aluminium_EPR_unarmoured_duct.put(147 , "70");
        currentCapacity_multi_aluminium_EPR_unarmoured_duct.put(176 , "95");
        currentCapacity_multi_aluminium_EPR_unarmoured_duct.put(201 , "120");
        currentCapacity_multi_aluminium_EPR_unarmoured_duct.put(226 , "150");
        currentCapacity_multi_aluminium_EPR_unarmoured_duct.put(257 , "185");
        currentCapacity_multi_aluminium_EPR_unarmoured_duct.put(300 , "240");
        currentCapacity_multi_aluminium_EPR_unarmoured_duct.put(340 , "300");
        currentCapacity_multi_aluminium_EPR_unarmoured_duct.put(392 , "400");

        currentCapacity_multi_aluminium_EPR_unarmoured_air.put(80 , "16");
        currentCapacity_multi_aluminium_EPR_unarmoured_air.put(105 , "25");
        currentCapacity_multi_aluminium_EPR_unarmoured_air.put(127 , "35");
        currentCapacity_multi_aluminium_EPR_unarmoured_air.put(151 , "50");
        currentCapacity_multi_aluminium_EPR_unarmoured_air.put(189 , "70");
        currentCapacity_multi_aluminium_EPR_unarmoured_air.put(229 , "95");
        currentCapacity_multi_aluminium_EPR_unarmoured_air.put(263 , "120");
        currentCapacity_multi_aluminium_EPR_unarmoured_air.put(299 , "150");
        currentCapacity_multi_aluminium_EPR_unarmoured_air.put(343 , "185");
        currentCapacity_multi_aluminium_EPR_unarmoured_air.put(406 , "240");
        currentCapacity_multi_aluminium_EPR_unarmoured_air.put(462 , "300");
        currentCapacity_multi_aluminium_EPR_unarmoured_air.put(538 , "400");

        currentCapacity_multi_aluminium_EPR_armoured_direct.put(76 , "16");
        currentCapacity_multi_aluminium_EPR_armoured_direct.put(97 , "25");
        currentCapacity_multi_aluminium_EPR_armoured_direct.put(116 , "35");
        currentCapacity_multi_aluminium_EPR_armoured_direct.put(137 , "50");
        currentCapacity_multi_aluminium_EPR_armoured_direct.put(168 , "70");
        currentCapacity_multi_aluminium_EPR_armoured_direct.put(200 , "95");
        currentCapacity_multi_aluminium_EPR_armoured_direct.put(227 , "120");
        currentCapacity_multi_aluminium_EPR_armoured_direct.put(254 , "150");
        currentCapacity_multi_aluminium_EPR_armoured_direct.put(288 , "185");
        currentCapacity_multi_aluminium_EPR_armoured_direct.put(332 , "240");
        currentCapacity_multi_aluminium_EPR_armoured_direct.put(374 , "300");
        currentCapacity_multi_aluminium_EPR_armoured_direct.put(426 , "400");

        currentCapacity_multi_aluminium_EPR_armoured_duct.put(66 , "16");
        currentCapacity_multi_aluminium_EPR_armoured_duct.put(85 , "25");
        currentCapacity_multi_aluminium_EPR_armoured_duct.put(101 , "35");
        currentCapacity_multi_aluminium_EPR_armoured_duct.put(120 , "50");
        currentCapacity_multi_aluminium_EPR_armoured_duct.put(147 , "70");
        currentCapacity_multi_aluminium_EPR_armoured_duct.put(176 , "95");
        currentCapacity_multi_aluminium_EPR_armoured_duct.put(201 , "120");
        currentCapacity_multi_aluminium_EPR_armoured_duct.put(226 , "150");
        currentCapacity_multi_aluminium_EPR_armoured_duct.put(257 , "185");
        currentCapacity_multi_aluminium_EPR_armoured_duct.put(299 , "240");
        currentCapacity_multi_aluminium_EPR_armoured_duct.put(338 , "300");
        currentCapacity_multi_aluminium_EPR_armoured_duct.put(387 , "400");

        currentCapacity_multi_aluminium_EPR_armoured_air.put(81 , "16");
        currentCapacity_multi_aluminium_EPR_armoured_air.put(105 , "25");
        currentCapacity_multi_aluminium_EPR_armoured_air.put(127 , "35");
        currentCapacity_multi_aluminium_EPR_armoured_air.put(153 , "50");
        currentCapacity_multi_aluminium_EPR_armoured_air.put(190 , "70");
        currentCapacity_multi_aluminium_EPR_armoured_air.put(230 , "95");
        currentCapacity_multi_aluminium_EPR_armoured_air.put(264 , "120");
        currentCapacity_multi_aluminium_EPR_armoured_air.put(300 , "150");
        currentCapacity_multi_aluminium_EPR_armoured_air.put(343 , "185");
        currentCapacity_multi_aluminium_EPR_armoured_air.put(402 , "240");
        currentCapacity_multi_aluminium_EPR_armoured_air.put(459 , "300");
        currentCapacity_multi_aluminium_EPR_armoured_air.put(530 , "400");


        currentCapacity.put(SINGLE_CORE , currentCapacity_single);
        currentCapacity.put(THREE_CORE ,  currentCapacity_multi);

        currentCapacity_single.put(COOPER ,    currentCapacity_single_cooper);
        currentCapacity_single.put(ALUMINIUM , currentCapacity_single_aluminium);

        currentCapacity_single_cooper.put(EPR ,  currentCapacity_single_cooper_EPR);
        currentCapacity_single_cooper.put(XLPE , currentCapacity_single_cooper_XLPE);

        currentCapacity_single_cooper_EPR.put(CABLE_IN_DUCTS , currentCapacity_single_cooper_EPR_duct);
        currentCapacity_single_cooper_EPR.put(DIRECT_BURIED ,  currentCapacity_single_cooper_EPR_direct);
        currentCapacity_single_cooper_EPR.put(AIR ,            currentCapacity_single_cooper_EPR_air);

        currentCapacity_single_cooper_EPR_duct.put(TOUCHING , currentCapacity_single_cooper_EPR_duct_touching);
        currentCapacity_single_cooper_EPR_duct.put(TREFOIL ,  currentCapacity_single_cooper_EPR_duct_trefoil);

        currentCapacity_single_cooper_EPR_direct.put(SPACED ,   currentCapacity_single_cooper_EPR_direct_spaced);
        currentCapacity_single_cooper_EPR_direct.put(TREFOIL ,  currentCapacity_single_cooper_EPR_direct_trefoil);

        currentCapacity_single_cooper_EPR_air.put(SPACED ,   currentCapacity_single_cooper_EPR_air_spaced);
        currentCapacity_single_cooper_EPR_air.put(TOUCHING , currentCapacity_single_cooper_EPR_air_touching);
        currentCapacity_single_cooper_EPR_air.put(TREFOIL ,  currentCapacity_single_cooper_EPR_air_trefoil);




        currentCapacity_single_cooper_XLPE.put(CABLE_IN_DUCTS , currentCapacity_single_cooper_XLPE_duct);
        currentCapacity_single_cooper_XLPE.put(DIRECT_BURIED ,  currentCapacity_single_cooper_XLPE_direct);
        currentCapacity_single_cooper_XLPE.put(AIR ,            currentCapacity_single_cooper_XLPE_air);

        currentCapacity_single_cooper_XLPE_duct.put(TOUCHING , currentCapacity_single_cooper_XLPE_duct_touching);
        currentCapacity_single_cooper_XLPE_duct.put(TREFOIL ,  currentCapacity_single_cooper_XLPE_duct_trefoil);

        currentCapacity_single_cooper_XLPE_direct.put(SPACED ,   currentCapacity_single_cooper_XLPE_direct_spaced);
        currentCapacity_single_cooper_XLPE_direct.put(TREFOIL ,  currentCapacity_single_cooper_XLPE_direct_trefoil);

        currentCapacity_single_cooper_XLPE_air.put(SPACED ,   currentCapacity_single_cooper_XLPE_air_spaced);
        currentCapacity_single_cooper_XLPE_air.put(TOUCHING , currentCapacity_single_cooper_XLPE_air_touching);
        currentCapacity_single_cooper_XLPE_air.put(TREFOIL ,  currentCapacity_single_cooper_XLPE_air_trefoil);




        currentCapacity_single_aluminium.put(EPR ,  currentCapacity_single_aluminium_EPR);
        currentCapacity_single_aluminium.put(XLPE , currentCapacity_single_aluminium_XLPE);

        currentCapacity_single_aluminium_EPR.put(CABLE_IN_DUCTS , currentCapacity_single_aluminium_EPR_duct);
        currentCapacity_single_aluminium_EPR.put(DIRECT_BURIED ,  currentCapacity_single_aluminium_EPR_direct);
        currentCapacity_single_aluminium_EPR.put(AIR ,            currentCapacity_single_aluminium_EPR_air);

        currentCapacity_single_aluminium_EPR_duct.put(TOUCHING , currentCapacity_single_aluminium_EPR_duct_touching);
        currentCapacity_single_aluminium_EPR_duct.put(TREFOIL ,  currentCapacity_single_aluminium_EPR_duct_trefoil);

        currentCapacity_single_aluminium_EPR_direct.put(SPACED ,   currentCapacity_single_aluminium_EPR_direct_spaced);
        currentCapacity_single_aluminium_EPR_direct.put(TREFOIL ,  currentCapacity_single_aluminium_EPR_direct_trefoil);

        currentCapacity_single_aluminium_EPR_air.put(SPACED ,   currentCapacity_single_aluminium_EPR_air_spaced);
        currentCapacity_single_aluminium_EPR_air.put(TOUCHING , currentCapacity_single_aluminium_EPR_air_touching);
        currentCapacity_single_aluminium_EPR_air.put(TREFOIL ,  currentCapacity_single_aluminium_EPR_air_trefoil);




        currentCapacity_single_aluminium_XLPE.put(CABLE_IN_DUCTS , currentCapacity_single_aluminium_XLPE_duct);
        currentCapacity_single_aluminium_XLPE.put(DIRECT_BURIED ,  currentCapacity_single_aluminium_XLPE_direct);
        currentCapacity_single_aluminium_XLPE.put(AIR ,            currentCapacity_single_aluminium_XLPE_air);

        currentCapacity_single_aluminium_XLPE_duct.put(TOUCHING , currentCapacity_single_aluminium_XLPE_duct_touching);
        currentCapacity_single_aluminium_XLPE_duct.put(TREFOIL ,  currentCapacity_single_aluminium_XLPE_duct_trefoil);

        currentCapacity_single_aluminium_XLPE_direct.put(SPACED ,   currentCapacity_single_aluminium_XLPE_direct_spaced);
        currentCapacity_single_aluminium_XLPE_direct.put(TREFOIL ,  currentCapacity_single_aluminium_XLPE_direct_trefoil);

        currentCapacity_single_aluminium_XLPE_air.put(SPACED ,   currentCapacity_single_aluminium_XLPE_air_spaced);
        currentCapacity_single_aluminium_XLPE_air.put(TOUCHING , currentCapacity_single_aluminium_XLPE_air_touching);
        currentCapacity_single_aluminium_XLPE_air.put(TREFOIL ,  currentCapacity_single_aluminium_XLPE_air_trefoil);






        currentCapacity_multi.put(COOPER ,    currentCapacity_multi_cooper);
        currentCapacity_multi.put(ALUMINIUM , currentCapacity_multi_aluminium);

        currentCapacity_multi_cooper.put(EPR ,  currentCapacity_multi_cooper_EPR);
        currentCapacity_multi_cooper.put(XLPE , currentCapacity_multi_cooper_XLPE);

        currentCapacity_multi_cooper_EPR.put(ARMOURED ,    currentCapacity_multi_cooper_EPR_armoured);
        currentCapacity_multi_cooper_EPR.put(UNARMOURED ,  currentCapacity_multi_cooper_EPR_unarmoured);

        currentCapacity_multi_cooper_EPR_armoured.put(AIR ,            currentCapacity_multi_cooper_EPR_armoured_air);
        currentCapacity_multi_cooper_EPR_armoured.put(CABLE_IN_DUCTS , currentCapacity_multi_cooper_EPR_armoured_duct);
        currentCapacity_multi_cooper_EPR_armoured.put(DIRECT_BURIED ,  currentCapacity_multi_cooper_EPR_armoured_direct);

        currentCapacity_multi_cooper_EPR_unarmoured.put(AIR ,            currentCapacity_multi_cooper_EPR_unarmoured_air);
        currentCapacity_multi_cooper_EPR_unarmoured.put(CABLE_IN_DUCTS , currentCapacity_multi_cooper_EPR_unarmoured_duct);
        currentCapacity_multi_cooper_EPR_unarmoured.put(DIRECT_BURIED ,  currentCapacity_multi_cooper_EPR_unarmoured_direct);


        currentCapacity_multi_cooper_XLPE.put(ARMOURED ,    currentCapacity_multi_cooper_XLPE_armoured);
        currentCapacity_multi_cooper_XLPE.put(UNARMOURED ,  currentCapacity_multi_cooper_XLPE_unarmoured);

        currentCapacity_multi_cooper_XLPE_armoured.put(AIR ,            currentCapacity_multi_cooper_XLPE_armoured_air);
        currentCapacity_multi_cooper_XLPE_armoured.put(CABLE_IN_DUCTS , currentCapacity_multi_cooper_XLPE_armoured_duct);
        currentCapacity_multi_cooper_XLPE_armoured.put(DIRECT_BURIED ,  currentCapacity_multi_cooper_XLPE_armoured_direct);

        currentCapacity_multi_cooper_XLPE_unarmoured.put(AIR ,            currentCapacity_multi_cooper_XLPE_unarmoured_air);
        currentCapacity_multi_cooper_XLPE_unarmoured.put(CABLE_IN_DUCTS , currentCapacity_multi_cooper_XLPE_unarmoured_duct);
        currentCapacity_multi_cooper_XLPE_unarmoured.put(DIRECT_BURIED ,  currentCapacity_multi_cooper_XLPE_unarmoured_direct);





        currentCapacity_multi_aluminium.put(EPR ,  currentCapacity_multi_aluminium_EPR);
        currentCapacity_multi_aluminium.put(XLPE , currentCapacity_multi_aluminium_XLPE);

        currentCapacity_multi_aluminium_EPR.put(ARMOURED ,    currentCapacity_multi_aluminium_EPR_armoured);
        currentCapacity_multi_aluminium_EPR.put(UNARMOURED ,  currentCapacity_multi_aluminium_EPR_unarmoured);

        currentCapacity_multi_aluminium_EPR_armoured.put(AIR ,            currentCapacity_multi_aluminium_EPR_armoured_air);
        currentCapacity_multi_aluminium_EPR_armoured.put(CABLE_IN_DUCTS , currentCapacity_multi_aluminium_EPR_armoured_duct);
        currentCapacity_multi_aluminium_EPR_armoured.put(DIRECT_BURIED ,  currentCapacity_multi_aluminium_EPR_armoured_direct);

        currentCapacity_multi_aluminium_EPR_unarmoured.put(AIR ,            currentCapacity_multi_aluminium_EPR_unarmoured_air);
        currentCapacity_multi_aluminium_EPR_unarmoured.put(CABLE_IN_DUCTS , currentCapacity_multi_aluminium_EPR_unarmoured_duct);
        currentCapacity_multi_aluminium_EPR_unarmoured.put(DIRECT_BURIED ,  currentCapacity_multi_aluminium_EPR_unarmoured_direct);


        currentCapacity_multi_aluminium_XLPE.put(ARMOURED ,    currentCapacity_multi_aluminium_XLPE_armoured);
        currentCapacity_multi_aluminium_XLPE.put(UNARMOURED ,  currentCapacity_multi_aluminium_XLPE_unarmoured);

        currentCapacity_multi_aluminium_XLPE_armoured.put(AIR ,            currentCapacity_multi_aluminium_XLPE_armoured_air);
        currentCapacity_multi_aluminium_XLPE_armoured.put(CABLE_IN_DUCTS , currentCapacity_multi_aluminium_XLPE_armoured_duct);
        currentCapacity_multi_aluminium_XLPE_armoured.put(DIRECT_BURIED ,  currentCapacity_multi_aluminium_XLPE_armoured_direct);

        currentCapacity_multi_aluminium_XLPE_unarmoured.put(AIR ,            currentCapacity_multi_aluminium_XLPE_unarmoured_air);
        currentCapacity_multi_aluminium_XLPE_unarmoured.put(CABLE_IN_DUCTS , currentCapacity_multi_aluminium_XLPE_unarmoured_duct);
        currentCapacity_multi_aluminium_XLPE_unarmoured.put(DIRECT_BURIED ,  currentCapacity_multi_aluminium_XLPE_unarmoured_direct);





    }


    public void init(){
        type = findViewById(R.id.spinner_type);
        insulation_material = findViewById(R.id.spinner_insulation);
        installation = findViewById(R.id.spinner_instalation);
        temp = findViewById(R.id.spinner_temp);
        soilNature = findViewById(R.id.spinner_soil_3p);
        depth = findViewById(R.id.spinner_depth);
        soilSpace = findViewById(R.id.spinner_spce_soil);
        soilInstallationMethod = findViewById(R.id.spinner_method_soil);
        soilCableNumber = findViewById(R.id.spinner_number_soil);
        airTrayNumber = findViewById(R.id.spinner_tray_air);
        airInstallationMethod = findViewById(R.id.spinner_method_air);
        airCableNumber = findViewById(R.id.spinner_circuit_air);
        soilNature1p = findViewById(R.id.spinner_soil_1p);

        one_core = findViewById(R.id.radioButton_1c);
        three_core = findViewById(R.id.radioButton_3c);
        one_phase = findViewById(R.id.radioButton_1p);
        three_phase = findViewById(R.id.radioButton_3p);

        voltage = findViewById(R.id.editText_voltage);
        current = findViewById(R.id.editText_Current);
        voltage_drop = findViewById(R.id.editText_voltagedrop);
        length = findViewById(R.id.editText_length);
        power_factor = findViewById(R.id.editText_powerfactor);
        short_circuit = findViewById(R.id.editText_shortcircuit);

        crossSection = findViewById(R.id.textView_result_cross);
        run = findViewById(R.id.textView_result_runs);
        voltage_drop_result = findViewById(R.id.textView_result_drop);

        next1 = findViewById(R.id.next1);
        next2 = findViewById(R.id.next2);
        back2 = findViewById(R.id.back2);
        back3 = findViewById(R.id.back3);
        back4 = findViewById(R.id.button_back4);
        calc = findViewById(R.id.calculate);

        layout_soil_3p = findViewById(R.id.soil_layout_3p);
        layout_soil_1p = findViewById(R.id.soil_layout_1p);
        layout_air = findViewById(R.id.air_layout_3p);

    }

    public void set_visibility(int air , int soil_3p , int soil_1p){
        layout_air.setVisibility(air);
        layout_soil_3p.setVisibility(soil_3p);
        layout_soil_1p.setVisibility(soil_1p);
    }

}