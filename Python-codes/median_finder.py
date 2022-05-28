"""
The median is the middle value of an ordered list 
of elements. If the elements count is even, then
the median is the average of the two middle elements.

For instance, in [3, 4, 5], median = 4, while
in [3, 4], median = (3+4)/2 = 3.5.

The below implementation creates a MedianFinder
class that streamlines the process of finding the median
for a stream of n values. 

Space complexity: O(n), to hold the values in heaps.
"""
from heapq import heappop, heappush


class median_finder:
    # Time complexity: O(1)
    def __init__(self):
        self.los = []
        self.his = []
        self.median = 0

    # Time complexity: O(log2(n))
    def add_num(self, num):
        if len(self.los) == 0 or (-1*self.los[0]) > num:
            heappush(self.los, -1*num)
        else:
            heappush(self.his, num)
        self.rebalance_his_los()
        self.update_median()

    # Time complexity: O(log2(n))
    def rebalance_his_los(self):
        los_length = len(self.los)
        his_length = len(self.his)

        if los_length - his_length == 2:
            heappush(self.his, -1*heappop(self.los))
        elif his_length - los_length == 2:
            heappush(self.los, -1*heappop(self.his))

    # Time complexity: O(1)
    def update_median(self):
        los_length = len(self.los)
        his_length = len(self.his)
        if los_length == his_length:
            self.median = (-1*self.los[0] + self.his[0])/2
        elif los_length > his_length:
            self.median = -1*self.los[0]
        else:
            self.median = self.his[0]

    # Time complexity: O(1)
    def find_median(self):
        return self.median


median_finder_obj1 = median_finder()
median_finder_obj1.add_num(3)
median_finder_obj1.add_num(4)
median_finder_obj1.add_num(5)
print("Median:", median_finder_obj1.find_median())  # Median: 4
median_finder_obj2 = median_finder()
median_finder_obj2.add_num(3)
median_finder_obj2.add_num(4)
print("Median:", median_finder_obj2.find_median())  # Median: 3.5
