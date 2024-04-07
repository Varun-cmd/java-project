package org.example.sample;
import java.util.Random;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.example.sample.model.macro;
import org.example.sample.model.nutrition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class SampleApplication {

    public static void main(String[] args) throws JRException {
        SpringApplication.run(SampleApplication.class, args);

        String filePath = "/home/vkumarv/Desktop/Project/sample/src/main/resources/templates/dietReport.jrxml";

        nutrition protien = new nutrition("Protein", 62, "g", 83);

        nutrition x = new nutrition("Protein",62,"G", 60);
        nutrition y = new nutrition("Carbs",150, "G", 120);
        nutrition z = new nutrition("fats",50,"G", 45);
        nutrition a = new nutrition("Vitamins",23,"G", 23);
        nutrition b = new nutrition("Minerals",17,"G", 15);



        List<nutrition> nutritionList = new ArrayList<>();
        nutritionList.add(protien);
        nutritionList.add(x);
        nutritionList.add(y);
        nutritionList.add(z);
        nutritionList.add(a);
        nutritionList.add(b);

        JRBeanCollectionDataSource nutritionDataSource = new JRBeanCollectionDataSource(nutritionList);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("nutritionDataset",nutritionDataSource);

        macro m1 = new macro("Fats",24);
        macro m2 = new macro("carbs",38);
        macro m3 = new macro("protein",32);
        macro m4 = new macro("minerals",15);

        List<macro> macroNutritionList = new ArrayList<>();
        macroNutritionList.add(m1);
        macroNutritionList.add(m2);
        macroNutritionList.add(m3);
        macroNutritionList.add(m4);

        JRBeanCollectionDataSource macroNutritionDataSource = new JRBeanCollectionDataSource(macroNutritionList);

        parameters.put("macroNutrientDataset",macroNutritionDataSource);

//
//        JasperReport report = JasperCompileManager.compileReport(filePath);
//        JasperPrint print = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
//        JasperExportManager.exportReportToPdfFile(print, "/home/vkumarv/Desktop/finalReport.pdf");
//
//



        Random random = new Random();
        long startTime = System.currentTimeMillis(); // Record start time

        for (int i = 0; i < 100; i++) {
            // Generate a unique filename using a random number
            String uniqueFileName = "/home/vkumarv/Desktop/sample/nutrientsReport_" + random.nextInt(1000000) + "_" + i + ".pdf";

            JasperReport report = JasperCompileManager.compileReport(filePath);
            JasperPrint print = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());

            JasperExportManager.exportReportToPdfFile(print, uniqueFileName);
        }

        long endTime = System.currentTimeMillis(); // Record end time
        long totalTimeMillis = endTime - startTime;
        double totalTimeSeconds = totalTimeMillis / 1000.0; // Convert milliseconds to seconds
        System.out.println("Total time taken: " + totalTimeSeconds + " seconds");





        System.out.println("Report Generated Successfully");

    }

}
