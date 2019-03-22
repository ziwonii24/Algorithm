#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0);
}

int n, L;
int arr[101][101];

bool sol(vector<int> &v) {	//v에는 n개의 숫자(한줄)가 들어있음
	int val = v[0];
	int cnt = 1;	//경사로를 둘 수 있는 연속하는 구간의 길이
	bool check = false;	//현재 구간에 경사로를 놓아야하는 경우

	for (int i = 1; i < v.size(); i++) {
		if (v[i] == val) {
			cnt++;
			continue;
		}
		else {
			if (check && cnt < L) return false;
			if (check) cnt -= L;
			check = false;

			if (val - v[i] < - 1 || val - v[i] > 1) //높이 차이가 1이상이면
				return false;

			if (val == v[i] - 1) {	//높이는 1낮은데
				if (cnt < L) //경사로둘수있는 자리가 모자르면
					return false;	
			}
			else //val==v[i]+1
				check = true;

			val = v[i];
			cnt = 1;
		}
	}

	if (check && cnt < L) return false;
	return true;
}

int main() {
	init();
	cin >> n >> L;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			cin >> arr[i][j];

	int cnt = 0;
	for (int i = 0; i < n; i++) {
		//가로줄 검사
		vector<int> v1;
		for (int j = 0; j < n; j++)
			v1.push_back(arr[i][j]);
		cnt += sol(v1);

		//세로줄 검사
		vector<int> v2;
		for (int j = 0; j < n; j++)
			v2.push_back(arr[j][i]);
		cnt += sol(v2);
	}
	cout << cnt;
	return 0;
}
