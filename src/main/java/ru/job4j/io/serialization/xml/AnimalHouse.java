package ru.job4j.io.serialization.xml;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "home")
@XmlAccessorType(XmlAccessType.FIELD)
public class AnimalHouse {
    @XmlAttribute
    private String name;
    @XmlElementWrapper(name = "animals")
    @XmlElement(name = "animal")
    private Animal[] animals;

    public AnimalHouse() {
    }

    public AnimalHouse(String name, Animal... animals) {
        this.name = name;
        this.animals = animals;
    }

    public Animal getFirst() {
        return animals[0];
    }

    @Override
    public String toString() {
        return "AnimalHouse{"
                + "name='" + name + '\''
                + ", animals=" + Arrays.toString(animals)
                + '}';
    }

    public static void main(String[] args) throws JAXBException, IOException {
        AnimalHouse house = new AnimalHouse("Home", new Animal("Tom"), new Animal("Jerry"));
        // Получаем контекст для доступа к АПИ
        JAXBContext context = JAXBContext.newInstance(AnimalHouse.class);
        // Создаем сериализатор
        Marshaller marshaller = context.createMarshaller();
        // Указываем, что нам нужно форматирование
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            // Сериализуем
            marshaller.marshal(house, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        // Для десериализации нам нужно создать десериализатор
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            // десериализуем
            AnimalHouse result = (AnimalHouse) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}

