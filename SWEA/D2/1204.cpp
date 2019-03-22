#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
}

const int MAX = 1000;
int n;
int arr[MAX], num[MAX+1];

int sol() {
	for (int i = 0; i < MAX; i++)
		num[i] = 0;
	for (int i = 0; i < MAX; i++)
		num[arr[i]]++;
	int max_cnt = 0;
	for (int i = 0; i < MAX; i++)
		max_cnt = max(max_cnt, num[i]);
	vector<int> v_idx;
	for (int i = 0; i < MAX; i++) {
		if (num[i] == max_cnt)
			v_idx.push_back(i);
	}
	sort(v_idx.begin(), v_idx.end());
	return v_idx.back();
}

int main() {
	init();
	int tc;
	cin >> tc;
	for (int T = 1; T <= tc; T++) {
		cin >> n;
		for (int i = 0; i < MAX; i++)
			cin >> arr[i];
		cout << '#' << T << ' ' << sol() << '\n';
	}
	return 0;
}
