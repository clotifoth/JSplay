# About

JSplay is a simple library implementation of a [splay tree data structure](https://en.wikipedia.org/wiki/Splay_tree) in Java.

# Why would I want to use JSplay / a splay tree?

A splay tree is essentially a [binary search tree](https://en.wikipedia.org/wiki/Binary_search_tree) wherein all operations are bound into one action called "splaying". Splaying essentially searches for a desired node and brings it to the root. As a splay is used repeatedly, more commonly accessed elements tend to drift to the center of the root, allowing for quicker access on average of these elements.

Thus, your application will benefit from a splay-tree-backed data structure if a few elements are used often, but will suffer if all elements are used nearly-equally.

If the statistical variance of your accesses is low, your application could benefit. If the variance is high, your application might not benefit as much.

# Use

Simply import the JSplay class and initialize it with your desired type generics.

----

If you like this project, visit my personal website at http://clotifoth.github.io/ to see what else I've been up to.
