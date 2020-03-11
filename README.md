# MyLinkedList2
This is simple doubly-linked <strong>sorted</strong> list.
It does not implements most of optional list operations, and permits only Integer values (not including null). I strongly do not recommend using this code in your real projects.

## Usage

```markdown

//Creating Class Instance

MyLinkedList2 thisList = new MyLinkedList2();

```

You can see [JavaDoc](https://mipoks.github.io/MyLinkedList2/) to read about all methods of MyLinkedList2


Below you can see a graph of time versus number of random elements. All methods were tested at low productivity to fix the slightest deviations from the norm. Most methods work for O(n) in theory and for O(1) in practice. On graphs N tends from 0 to 200. Some methods can be optimized (for example, divide() - works for O(n^2), but can be upgraded to O(n))

<img src="https://raw.githubusercontent.com/mipoks/MyLinkedList2/master/docs/images/insert2.PNG" width="250"> <img src="https://raw.githubusercontent.com/mipoks/MyLinkedList2/master/docs/images/delete2.PNG" width="250"> <img src="https://raw.githubusercontent.com/mipoks/MyLinkedList2/master/docs/images/divide2.PNG" width="250">
<img src="https://raw.githubusercontent.com/mipoks/MyLinkedList2/master/docs/images/maxNum2.PNG" width="250">
<img src="https://raw.githubusercontent.com/mipoks/MyLinkedList2/master/docs/images/newList2.PNG" width="250">
<img src="https://raw.githubusercontent.com/mipoks/MyLinkedList2/master/docs/images/size2.PNG" width="250">
<img src="https://raw.githubusercontent.com/mipoks/MyLinkedList2/master/docs/images/MyLinkedList2.PNG" width="250">
<img src="https://raw.githubusercontent.com/mipoks/MyLinkedList2/master/docs/images/merge2.PNG" width="250">
<img src="https://raw.githubusercontent.com/mipoks/MyLinkedList2/master/docs/images/get2.PNG" width="250">

