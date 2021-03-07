#include <string>
#include <vector>

using namespace std;

string solution(vector<int> numbers, string hand) {
    string answer = "";
    
    int lcur = 10;
    int rcur = 12;
    int ldist = 0;
    int rdist = 0;
    
    for(int i=0; i<numbers.size(); i++){
        int n = numbers[i];
        if((n==1)||(n==4)||(n==7)){
            answer.push_back('L');
            lcur = n;
        }else if((n==3)||(n==6)||(n==9)){
            answer.push_back('R');
            rcur = n;
        }else{
            if(n==0){
                n = 11;
            }
            int l = abs(lcur-n);
            int r = abs(rcur-n);
            ldist = l/3 + l%3;
            rdist = r/3 + r%3;
            if(ldist == rdist){
                if(hand == "left"){
                    answer.push_back('L');
                    lcur = n;
                }else{
                    answer.push_back('R');
                    rcur = n;
                }
            }else if (ldist < rdist){
                answer.push_back('L');
                lcur = n;
            }else{
                answer.push_back('R');
                rcur = n;
            }
        }
    }
    return answer;
}