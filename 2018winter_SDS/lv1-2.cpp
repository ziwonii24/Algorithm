#include <iostream>
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

int car[1010];
int color[55];
int color_chk[55];
int ans, tcIndex = 0;
int cnt = 0, cnt_chk = 0;
  
int main() {

	int tc;
	cin >> tc;
	while (tc--) {
		cnt = 0;
		cnt_chk = 0;
		ans = 0;
		int n, m;
		cin >> n >> m;
		for (int i = 0; i < m; i++) {
			cin >> color[i];
		}
		for (int i = 0; i < n; i++) {
			cin >> car[i];
		}
		for (int i = 0; i < m; i++) {
			color_chk[i] = 0;
		}
		for (int i = 0; i < m; i++) {
			if (color[i] != 0)
				cnt+=color[i];
		}

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (color[car[j] - 1] != 0
					&& color_chk[car[j] - 1] < color[car[j] - 1]) {
					color_chk[car[j] - 1] += 1;

					for (int k = 0; k < m; k++) {
						cnt_chk+=color_chk[k];
					}
					if (cnt == cnt_chk)
						ans = i+1;
					else {
						cnt_chk = 0;
					}
				}
				else {
					for (int k = 0; k < m; k++) {
						color_chk[k] = 0;
					}
					break;
				}
			}
		}
		
		tcIndex += 1;
		printf("#%d %d\n", tcIndex, ans);
	}
	
	return 0;
}