"""
The below code provides an implementation
for a Least Recently Used (LRU) cache.

An LRU cache:
1. discards the least recently used item if cache is full
2. places a new item at the front of the cache
3. returns a requested item and then places it at front of cache. 

Time complexity: O(1) for put and get methods
Space complexity: O(capacity of LRU cache) 
"""

from collections import OrderedDict


class LRUCache(OrderedDict):
    # Initialize capacity of cache
    def __init__(self, capacity):
        self.capacity = capacity

    # Get the item associated with key
    def get(self, key):
        if key not in self:
            return - 1
        # Move requested item to front of cache
        self.move_to_end(key, last=False)
        return self[key]

    def put(self, key, value):
        # Insert/Update item
        self[key] = value
        # Move new item to front of cache
        self.move_to_end(key, last=False)
        # Apply cache eviction policy
        # Removing the item at end of cache
        # i.e., the least recently used item
        if len(self) > self.capacity:
            self.popitem()


cache = LRUCache(2)

cache.put("First item", 1)
cache.put("Second item", 2)
# Cache content: "Second item": 2, "First item": 1
print(cache.get("First item"))  # 1
# Cache content: "First item": 1, "Second item": 2
cache.put("Third item", 3)
# Cache content: "Third item": 3, "First item": 1
print(cache.get("Second item"))  # -1
