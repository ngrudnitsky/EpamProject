package by.epam.nickgrudnitsky.project.service;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class Parser {

    //метод парсит входные данные, возвраща список с тарифами
    static List<List<String>> readPlansFromFile(File file) {

        List<List<String>> tariffs = new ArrayList<>();  //лист, хранящий в себе тарифы

        if (file.exists()) {

            try (BufferedReader in = new BufferedReader(new FileReader(file))) {

                while (in.ready()) {
                    List<String> tariffInfo = new ArrayList<>();
                    String planName = in.readLine();

                    if (planName.startsWith("Тариф Мобильный")) {

                        tariffInfo.add(planName);

                        for (int i = 0; i < 11; i++) {

                            if (in.ready()) {

                                String[] split = in.readLine().split(" = ");
                                tariffInfo.add(split[1]);

                            }
                        }

                        tariffs.add(tariffInfo);

                    } else if (planName.startsWith("Тариф Для Квартиры")){

                        tariffInfo.add(planName);

                        for (int i = 0; i < 8; i++) {

                            if (in.ready()) {

                                String[] split = in.readLine().split(" = ");
                                tariffInfo.add(split[1]);

                            }
                        }

                        tariffs.add(tariffInfo);
                    } else if (planName.startsWith("Тариф Для Дома")){

                        tariffInfo.add(planName);

                        for (int i = 0; i < 9; i++) {

                            if (in.ready()) {

                                String[] split = in.readLine().split(" = ");
                                tariffInfo.add(split[1]);

                            }
                        }

                        tariffs.add(tariffInfo);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return tariffs;

    }
}
