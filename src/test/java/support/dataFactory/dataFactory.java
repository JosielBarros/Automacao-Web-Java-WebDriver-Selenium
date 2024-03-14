package support.dataFactory;

import com.github.javafaker.Faker;

public class dataFactory {
    public static String gerarTituloProduto(){
        Faker faker = new Faker();
        return faker.book().title();
    }
}
