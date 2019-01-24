#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
#include <algorithm>
using namespace std;

int main() {
	int cnt = 0;
	int n;
	scanf("%d", &n);

	while (n--) {
		bool isGroup = true;
		bool check[26];
		for (int i = 0; i < 26; i++)
			check[i] = false;

		char str[101];
		scanf("%s", str);

		for (int i = 0; i < 101; i++) {
			if (str[i] == 0) break;
			if (str[i] != str[i + 1]) {				
				if (!check[str[i] - 97])
					check[str[i] - 97] = true;
				else
					isGroup = false;
			}
		}

		if (isGroup) cnt++;
	}

	printf("%d\n", cnt);

	return 0;
}
