/* 문제 푸는 방법

    while(자리수를 하나씩 이동하면서){
        if(현재 자리수 > 5){
            (플래그 올림 or 플래그 중립 이면) : 현재 자리수 ++;
            (10-현재자리수)사용;
            (현재 자리수에 따라) : 플래그 설정
        }
        
        else if(현재 자리수 < 5){
            (플래그 올림상태이면) : 현재 자리수 ++;
            (현재자리수)사용;
            (현재 자리수에 따라) : 플래그 설정
        }
        
        else if(현재 자리수 == 5){
            (플래그 올림 or 플래그 중립 이면) : 현재 자리수 ++;
            (10-현재자리수) 사용;
            (현재 자리수에 따라) : 플래그 설정
        }
    }  
    */

#include <string>
#include <vector>

using namespace std;

#define UP 1
#define DOWN 2
#define NEUT 3

int solution(int storey) {
    
    int magicstone = 0;
    vector<int> num;
    // 문자열 num에는 storey가 역순으로 들어감 (2554 -> {4, 5, 5, 2})
    while(1){
        int a = storey%10;
        num.push_back(a);
        storey -= a;
        if(storey==0){
            break;
        }
        storey = storey/10;        
    }
    int flag = 0;
    for(int i=0;i<num.size();i++){
        if(num[i]>=5){   // 현재 자리수
            if(flag==UP||flag==NEUT){   // 플래그 올림 or 중립 이면
                num[i] ++;                
            }
            magicstone += (10-num[i]);  // (10 - 현재자리수) magicstone 사용
            // 플래그 설정
            if(num[i]>5){flag = UP;}
            else if(num[i]<5){flag = DOWN;}
            else if(num[i]==5){flag = NEUT;}
        }
        else if(num[i]<5){
            if(flag==UP){   // 플래그 올림상태 이면
                num[i] ++;
            }
            magicstone += num[i];       // (현재자리수) magicstone 사용
            // 플래그 설정
            if(num[i]>5){flag = UP;}
            else if(num[i]<5){flag = DOWN;}
            else if(num[i]==5){flag = NEUT;}
        }/*
        else if(num[i]==5){
            if(flag==UP||flag==NEUT){   // 플래그 올림 or 중립 이면
                num[i] ++;                
            }
            magicstone += (10-num[i]);  // (10 - 현재자리수) magicstone 사용
            // 플래그 설정
            if(num[i]>5){flag = UP;}
            else if(num[i]<5){flag = DOWN;}
        }*/
    }
    if(flag==UP){
        magicstone ++;
    }
    
    int answer = magicstone;
    return answer;
}