# -*- coding: utf-8 -*-
# 一次打印四个数字

nums = (1..16).to_a
index = -1
nums.each_slice(4) do |each|
  puts "==="
  puts each
end
