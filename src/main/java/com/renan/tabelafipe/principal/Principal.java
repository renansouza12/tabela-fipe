package com.renan.tabelafipe.principal;

import java.io.IOException;
import java.util.Comparator;
import java.util.Scanner;

import com.renan.tabelafipe.model.Data;
import com.renan.tabelafipe.model.Models;
import com.renan.tabelafipe.service.Api;
import com.renan.tabelafipe.service.DataConverter;

public class Principal {
    private Scanner sc = new Scanner(System.in);
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";   
    private Api api = new Api();
    private DataConverter dataConverter = new DataConverter();

    public void displayMenu() throws IOException, InterruptedException {
        var menu = """
                Options:

                -> Car

                -> Motorcycle
                
                -> Truck

                Type an option to search:
                """;

        System.out.println(menu);
        var option = sc.nextLine();

        String address;

        if(option.toLowerCase().contains("car")) {
            address = String.format("%scarros/marcas", URL_BASE);
        } else if(option.toLowerCase().contains("mot")) {
            address = String.format("%smotos/marcas", URL_BASE);
        } else {
            address = String.format("%scaminhoes/marcas", URL_BASE);
        }
        
        var json = api.getData(address);

        var brands = dataConverter.getList(json, Data.class);
        brands.stream()
            .sorted(Comparator.comparing(Data::code))
            .forEach(System.out::println);

        System.out.println("Provide code's brand: ");
        var codeBrand = sc.nextLine();

        address = String.format("%s/%s/modelos", address, codeBrand);
        json = api.getData(address);
        var listModel = dataConverter.getData(json, Models.class);  // Ensure json is passed, not the URL
        System.out.println("Brand models:");
        listModel.models().stream().sorted(Comparator.comparing(Data::code))
            .forEach(System.out::println);
    }
}
