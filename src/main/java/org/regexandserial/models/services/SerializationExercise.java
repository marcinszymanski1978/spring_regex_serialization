package org.regexandserial.models.services;

import org.springframework.stereotype.Service;
import org.regexandserial.models.UserRegisterInput;

import java.io.*;

@Service
public class SerializationExercise {

    public void saveObject(File file, UserRegisterInput object){

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos= new FileOutputStream("fileTest.txt"); //utworzenie strumienia wyjściowego
            oos = new ObjectOutputStream(fos);  //utworzenie obiektu zapisującego do strumienia

            oos.writeObject(object); //serializacja obiektu

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // zamykamy strumienie w finally
            try {
                if (oos != null) oos.close();
            } catch (IOException e) {}
            try {
                if (fos != null) fos.close();
            } catch (IOException e) {}
        }

       }

    public UserRegisterInput loadObject(File file){

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("fileTest.txt"); //utworzenie strumienia wejściowego
            ois = new ObjectInputStream(fis); //utworzenie obiektu odczytującego obiekty ze strumienia

             file = (File) ois.readObject(); //deserializacja obiektu

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // zasoby zwalniamy w finally
            try {
                if (ois != null) ois.close();
            } catch (IOException e) {}
            try {
                if (fis != null) fis.close();
            } catch (IOException e) {}
        }


        //todo load object from file
        return new UserRegisterInput();
    }

}
