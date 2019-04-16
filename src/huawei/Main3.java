package huawei;



import java.util.*;

public class Main3 {
    static class Rmattempt{
        public String source;
        public String id;
        public String status;

        public Rmattempt(String source, String id, String status) {
            this.source = source;
            this.id = id;
            this.status = status;
        }
    }
    public static HashMap<String, Integer> status = new HashMap<>();
    public static HashMap<String, Integer> source = new HashMap<>();
    public static HashMap<String, String> shijian = new HashMap<>();
    public static boolean judge(Rmattempt rmattempt, Rmattempt temp) {
        if (rmattempt.status == "killed")
            return false;
        else if (temp.status == "killed")
            return true;
        else if ((source.get(rmattempt.source) == (source.get(temp.source) - 1)) &&
                    (status.get(rmattempt.status) == status.get(temp.status) - 1)){
            return true;
        }
        else return false;

    }
    public static void main(String[] args) {
        status.put("submitted",0);
        status.put("scheduled",1);
        status.put("allocated",2);
        status.put("running",3);
        status.put("finished",4);
        status.put("killed",5);
        source.put("RmApp",0);
        source.put("ResourceScheduler",1);
        source.put("ApplicationMasterLauncher",2);
        source.put("RmContainer",3);
        shijian.put("start", "submitted");
        shijian.put("app_accepted", "scheduled");
        shijian.put("container_allocated", "allocated");
        shijian.put("launched", "running");
        shijian.put("finished", "finished");
        shijian.put("kill", "killed");

        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] arr=str.split(" ");
        TreeMap<String, Rmattempt> record = new TreeMap<>();
        ArrayList<Rmattempt> ans = new ArrayList<>();
        for (int i=0;i<arr.length;i++){
            String[] arr2=arr[i].split("\\|");
            arr2[2] = shijian.get(arr2[2]);
            Rmattempt temp = new Rmattempt(arr2[0],arr2[1],arr2[2]);
            if (record.containsKey(temp.id)){
                //kill youxianji gao;
                if (judge(record.get(temp.id), temp)){
                    record.put(temp.id, temp);
                    ans.add(temp);
                }
            }
            else {
                record.put(temp.id, temp);
                ans.add(temp);
            }
        }
        String res = "";
        for (int i=0;i<ans.size();i++){
            res += ans.get(i).id;
            res +='|';
            res += ans.get(i).status;
            res +=';';
        }

        System.out.println(res);
    }




}
