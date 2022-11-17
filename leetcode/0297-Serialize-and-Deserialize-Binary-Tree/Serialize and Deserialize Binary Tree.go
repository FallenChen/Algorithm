package leetcode

import (
	"algorithm/structures"
	"strconv"
	"strings"
)

type TreeNode = structures.TreeNode

type Codec struct {
	builder strings.Builder
	input   []string
}

func Constructor() Codec {
	return Codec{}
}

// Serializes a tree to a single string.
func (codec *Codec) serialize(root *TreeNode) string {
	if root == nil {
		codec.builder.WriteString("#,")
		return ""
	}

	codec.builder.WriteString(strconv.Itoa(root.Val) + ",")
	codec.serialize(root.Left)
	codec.serialize(root.Right)
	return codec.builder.String()
}

// Deserializes your encoded data to tree.
func (codec *Codec) deserialize(data string) *TreeNode {

	if len(data) == 0 {
		return nil
	}
	codec.input = strings.Split(data, ",")
	return codec.deserializeHelper()
}

func (codec *Codec) deserializeHelper() *TreeNode {

	if codec.input[0] == "#" {
		codec.input = codec.input[1:]
		return nil
	}

	val, _ := strconv.Atoi(codec.input[0])
	codec.input = codec.input[1:]
	return &TreeNode{
		Val:   val,
		Left:  codec.deserializeHelper(),
		Right: codec.deserializeHelper(),
	}
}
