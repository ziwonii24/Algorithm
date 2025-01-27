#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
#include <algorithm>
#include <cstring>
#include <deque>
using namespace std;

const int max_len = 100000;

int main() {
	int tc;
	scanf("%d", &tc);
	while (tc--) {
		char p[max_len + 1];
		int n;
		char a[max_len * 4 + 1];

		scanf("%s", p);
		scanf("%d", &n);
		scanf("%s", a);

		deque<int> dq;
		int idx = 0;
		char num[4];

		//input setting, deque
		for (int i = 1; i < max_len * 4 + 1; i++) {
			if (a[i] != ',' && a[i] != ']') {	//a[i]가 숫자이면,
				num[idx++] = a[i] - '0';
			}
			else if (a[i] == ',' || a[i] == ']') {
				int x = 1, y = 0;
				for (int k = idx - 1; k >= 0; k--) {
					y += num[k] * x;
					x *= 10;
				}
				if(y!=0) dq.push_back(y);
				idx = 0;
			}
						
			if (a[i] == ']') break;
		}

		bool flag = true;	//true가 앞부터, false가 뒤부터
		bool err_chk = false;

		//명령어 수행
		for (int i = 0; i < max_len + 1; i++) {
			if (p[i] == 0) break;
			if (p[i] == 'R') {
				if (flag) flag = false;
				else flag = true;
			}
			else if (p[i] == 'D') {
				if (dq.size() == 0) {
					err_chk = true;
					break;
				}

				if (flag) dq.pop_front();
				else dq.pop_back();
			}
		}

		//output
		if (err_chk)
			printf("error\n");
		else {
			printf("[");
			int dqsize = dq.size();
			int cnt = 0;

			if(dqsize==0) printf("]\n");
			if (flag) {
				while (!dq.empty()) {
					cnt++;
					printf("%d", dq.front());
					if (dqsize==cnt) printf("]\n");
					else printf(",");
					dq.pop_front();
				}
			}
			else {
				while (!dq.empty()) {
					cnt++;
					printf("%d", dq.back());
					if (dqsize==cnt) printf("]\n");
					else printf(",");
					dq.pop_back();
				}
			}
		}
	}

	return 0;
}
