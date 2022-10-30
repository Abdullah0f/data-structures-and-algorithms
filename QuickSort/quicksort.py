def quickSort(list):
    if len(list) <= 1:
        return list
    else:
        pivot = list.pop(0)
        items_greater = []
        items_lower = []
        for item in list:
            if item > pivot:
                items_greater.append(item)
            else:
                items_lower.append(item)
        return quickSort(items_lower) + [pivot] + quickSort(items_greater)


def quickSort(list):


print(quickSort([5, 3, 6, 2, 10]))
