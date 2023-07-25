package dev.gruncan.spotify;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RequestClasses {


    public static void main(String[] args) {
        String dir = "src/main/java/dev/gruncan/spotify/webapi/requests/";
        File base = new File(dir);
        List<String> allNames = new ArrayList<>();
        for (File f : base.listFiles()){
            if (f.isDirectory() && !f.getPath().endsWith("util")){
                List<String> names = getClassNames(f.listFiles());
                allNames.addAll(names);
            }
        }

        System.out.println(allNames.stream().map(s -> "\"" + s + "\"").toList().toString());
    }

    private static List<String> getClassNames(File[] files){
        List<String> list = new ArrayList<>();
        for (File file : files){
            if (file.isDirectory()){
                list.addAll(getClassNames(file.listFiles()));
            }else{
                String name = file.getPath();
                name = name.replace("src\\main\\java\\", "")
                        .replace(".java", "")
                        .replace("\\", ".");
//                String[] dir = name.split("\\.");
//                name = dir[dir.length-1];


                list.add(name);
            }
        }
        return list;
    }

}
