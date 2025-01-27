#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <vector>
#include <algorithm>
#include <functional>
using namespace std;

int n;
vector<int> v;

int main() {
	ios_base::sync_with_stdio(0);
	cin.tie(0);
	
	cin >> n;

	while (n) {
		v.push_back(n % 10);
		n /= 10;
	}

	sort(v.begin(), v.end(), greater<int>());

	for (int i = 0; i < v.size(); i++) {
		cout << v.at(i);
	}
	cout << '\n';

	return 0;
}
