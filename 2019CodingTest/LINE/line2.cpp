#include <iostream>
#include <algorithm>
#include <string>
#include <queue>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0);
}


int main() {
	init();

	string str;
	cin >> str;
	
	queue<char> qc;	
	queue<char> qn;

	for (int i = 0; i < str.size(); i++) {
		if (str[i] >= '0' && str[i] <= '9') qn.push(str[i]);
		else qc.push(str[i]);
	}

	if (qn.empty()) {		//입력에 숫자가 없을 경우
		cout << str;
		return 0;
	}

	string ans;
	while (!qn.empty()) {
		if (qc.empty()) {
			cout << "error";
			return 0;
		}

		ans += qc.front();
		qc.pop();

		if (qn.front() == '1') {
			qn.pop();
			if (!qn.empty()) {
				if (qn.front() == '0') {
					ans += "10";
					qn.pop();
				}
			}
		}
		else {
			ans += qn.front();
			qn.pop();
		}
	}

	if (!qc.empty()) cout << "error";
	else cout << ans;

	return 0;
}