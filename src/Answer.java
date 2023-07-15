import java.util.Arrays;

public class Answer {
    public static StringBuilder answer(String QUERY, String PARAMS){
        // Напишите свое решение ниже
        StringBuilder result = new StringBuilder();
        String [] temp = Arrays.stream( PARAMS.replace(" ","").split("\\p{Punct}"))
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);
        result.append(QUERY);
        System.out.println(PARAMS);

        for (int i = 0; i < temp.length; i++){
            if (temp[i].contains("null")) {
                temp[i] = ""; temp[i-1] = "";
            }
        }
        String[] temp1 =  Arrays.stream(temp)
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);
        Arrays.stream(temp).forEach(System.out::println);
        for (int i = 0; i < temp1.length ; i+=2) {
            result.append(temp1[i])
                    .append("='")
                    .append(temp1[i+1])
                    .append("'")
                    .append(" and ");

        }
        result.delete(result.length()-5,result.length()-1);

        return result;
    }
//select * from students1111 where name='Andron' and country='Russia' and city='Moscow'



   /* public static StringBuilder answer(String JSON, String ELEMENT1, String ELEMENT2, String ELEMENT3){
        StringBuilder resault = new StringBuilder();
        System.out.println(JSON);
        String [] word = Arrays.stream( JSON.replace("},{","z").split("\\p{Punct}"))
                .filter(s -> !s.isEmpty())
                .map(s -> s.replace("фамилия",ELEMENT1))
                .map(s -> s.replace("оценка",ELEMENT2))
                .map(s -> s.replace("предмет",ELEMENT3))
                .map(s -> s.replace("z","\n"))
                .toArray(String[]::new);
        for (String s: word)
            resault.append(s);
        System.out.println(resault);

        return  resault;
    } */
}
