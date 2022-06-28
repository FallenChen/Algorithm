package leetcode

func rotate(nums []int, k int) {

	k %= len(nums)
	reverse(nums)
	reverse(nums[:k])
	reverse(nums[k:])
}

//nums = "----->-->"; k =3
//result = "-->----->";

//reverse "----->-->" we can get "<--<-----"
//reverse "<--" we can get "--><-----"
//reverse "<-----" we can get "-->----->"

func reverse(a []int) {
	for i, n := 0, len(a); i < n/2; i++ {
		a[i], a[n-1-i] = a[n-1-i], a[i]
	}
}
