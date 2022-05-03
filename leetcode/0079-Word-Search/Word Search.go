package leetcode




func exist(board [][]byte, word string) bool {

	for i:=0; i<len(board); i++ {
		for j:=0; j<len(board[0]); j++ {
			if isExit(board,i,j,word,0) {
				return true
			}
		}
	}
	return false
}

func isExit(board [][]byte, i,j int, word string, index int) bool {
	if index == len(word) {
		return true
	}
	if i > len(board)-1 || i < 0 || j <0 || j > len(board[0])-1 || board[i][j] != word[index] {
		return false
	}
	temp := board[i][j]
	board[i][j] = '0'
	// any of this ture ,then exit
	exit := isExit(board, i-1,j, word, index + 1) ||
		isExit(board, i, j-1, word, index + 1) ||
		isExit(board, i+1, j, word, index + 1) ||
		isExit(board, i, j+1, word, index + 1);
	board[i][j] = temp
	return exit


}