import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    private char[] data;

    // Конструктор
    public Main(String str) {
        this.data = str.toCharArray();
    }

    public Main reverse()
    {
        int len = data.length;
        char[] reversed = new char[len];
        for (int i = 0; i < len; i++)
        {
            reversed[i] = data[len - 1 - i];
        }
        return new Main(new String(reversed));
    }

    public Main concatenate(Main other)
    {
        int totalLength = this.data.length + other.data.length;
        char[] concatenated = Arrays.copyOf(this.data, totalLength);
        System.arraycopy(other.data, 0, concatenated, this.data.length, other.data.length);
        return new Main(new String(concatenated));
    }

    public void printAndSave(String filename) {
        String result = new String(data);
        System.out.println(result);

        try (FileWriter writer = new FileWriter(filename))
        {
            writer.write(result);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public String toString()
    {
        return new String(data);
    }

    public static void main(String[] args) {
        Main str1 = new Main("Hello");
        Main str2 = new Main("World");
        Main reversedStr = str1.reverse();
        System.out.println("Reversed String: " + reversedStr);
        reversedStr.printAndSave("reversed.txt");
        Main concatenatedStr = str1.concatenate(str2);
        System.out.println("Concatenated String: " + concatenatedStr);
        concatenatedStr.printAndSave("concatenated.txt");
    }
}
