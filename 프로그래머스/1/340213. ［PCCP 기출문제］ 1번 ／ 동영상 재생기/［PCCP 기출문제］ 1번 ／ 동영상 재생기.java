import java.util.*;
class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        //String answer = "";
        
        //System.out.println(parseIntTime(pos));
        
        int curTime = parseIntTime(pos);
        
        for(String command : commands){
            if(isInOp(curTime, op_start, op_end)){
               curTime = parseIntTime(op_end);
            }
            if(command.equals("prev")){
                curTime = cmPrev(curTime);
            }
            else{
                curTime = cmNext(curTime, video_len);
            }
        }
        if(isInOp(curTime, op_start, op_end)){
            curTime = parseIntTime(op_end);
        }
        
        String strTime = parseStringTime(curTime);
        //System.out.println(strTime);
        
        return strTime;
    }
    
    private int parseIntTime(String pov){
        return (pov.charAt(0)-48)*1000
            + (pov.charAt(1)-48)*100
            + (pov.charAt(3)-48)*10
            + (pov.charAt(4)-48);
    }
    
    private int cmPrev(int pov){
        if(pov<11){
            return 0;
        }
        if(pov%100<10){
            return pov-50;
        }
        return pov-10;
    }
    
    private int cmNext(int pov, String video_l){
        int end = parseIntTime(video_l);
        if(pov%100>50){
            if(pov+50>=end){
                return end;
            }
            return pov+50;
        }
        if(pov+10>=end){
            return end;
        }
        return pov+10;
    }
    
    private boolean isInOp(int curT, String op_s, String op_e){
        int ops = parseIntTime(op_s);
        int ope = parseIntTime(op_e);
        if(curT<ope&&curT>=ops){
            return true;
        }
        return false;
    }
    
    private String parseStringTime(int pov){
        if(pov/100==0){
            if((pov%100)/10==0){
                return "00:0"+String.valueOf(pov%10);
            }
            return "00:"+String.valueOf(pov%100);
        }
        if(pov/1000==0){
            if((pov%100)/10==0){
                return "0"+String.valueOf(pov/100)+":0"+String.valueOf(pov%10);
            }
            return "0"+String.valueOf(pov/100)+":"+String.valueOf(pov%100);
        }
        if((pov%100)/10==0){
            return String.valueOf(pov/100)+":0"+String.valueOf(pov%10);
        }
        return String.valueOf(pov/100)+":"+String.valueOf(pov%100);
    }
}