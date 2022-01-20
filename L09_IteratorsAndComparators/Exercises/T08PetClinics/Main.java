package M03_JavaAdvanced.L09_IteratorsAndComparators.Exercises.T08PetClinics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private final static String INVALID_OPERATION = "Invalid Operation!";
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        List<Pet> pets = new ArrayList<>();
        List<Clinic> clinics = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] lines = bufferedReader.readLine().split("\\s+");
            String command = lines[0];

            switch (command) {
                case "Create":
                    if (lines[1].equals("Pet")) {
                        String petName = lines[2];
                        int petAge = Integer.parseInt(lines[3]);
                        String petKind = lines[4];
                        pets.add(new Pet(petName, petAge, petKind));
                    } else if (lines[1].equals("Clinic")) {
                        int numberOfRooms = Integer.parseInt(lines[3]);
                        if (numberOfRooms % 2 == 0) {
                            System.out.println(INVALID_OPERATION);
                            break;
                        }
                        String clinicName = lines[2];
                        clinics.add(new Clinic(clinicName, numberOfRooms));
                    }
                    break;
                case "HasEmptyRooms":
                    String clinicNam = lines[1];
                    Clinic clinicc = clinics.stream().filter(c -> c.getName().equals(clinicNam)).findFirst().orElse(null);
                    if (clinicc == null) {
                        System.out.println(INVALID_OPERATION);
                        break;
                    }
                    System.out.println(clinicc.hasEmptyRoom());
                    break;
                case "Release":
                    String clinicReleaseName = lines[1];
                    Clinic clinicRelease = clinics.stream().filter(c -> c.getName().equals(clinicReleaseName)).findFirst().orElse(null);
                    if (clinicRelease == null) {
                        System.out.println(INVALID_OPERATION);
                        break;
                    }
                    System.out.println(clinicRelease.release());
                    break;
                case "Add":
                    String petName = lines[1];
                    String clinicName = lines[2];
                    Clinic clinic = clinics.stream().filter(c -> c.getName().equals(clinicName)).findFirst().orElse(null);
                    if (clinic == null) {
                        System.out.println(INVALID_OPERATION);
                        break;
                    }
                    Pet pet = pets.stream().filter(p -> p.getName().equals(petName)).findFirst().orElse(null);
                    if (pet == null) {
                        System.out.println(INVALID_OPERATION);
                        break;
                    }
                    System.out.println(clinic.add(pet));
                    break;
                case "Print":
                    String printClinicName = lines[1];
                    Clinic clinicPrint = clinics.stream().filter(c -> c.getName().equals(printClinicName)).findFirst().orElse(null);
                    if (clinicPrint == null) {
                        System.out.println(INVALID_OPERATION);
                        break;
                    }
                    if (lines.length == 3) {
                        clinicPrint.print(Integer.parseInt(lines[2]));
                    } else {
                        clinicPrint.print();
                    }
                    break;
                default:
                    break;
            }
        }

    }
}