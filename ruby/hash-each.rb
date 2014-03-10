# -*- coding: utf-8 -*-
# 这个例子说明 hash 的 each 在只接受一个参数的时候是返回
# ["grandpa", {"dad"=>{"child 1"=>{}, "child 2"=>{}}, "uncle"=>{"child 3"=>{}, "child 4"=>{}}}]
# 而非简单的 value 或者 key => value

family = {
  'grandpa' => {
    'dad' => {
      'child 1' => {},
      'child 2' => {}
    },
    'uncle' => {
      'child 3' => {},
      'child 4' => {}
    }
  }
}

family.each do |key, value|
  puts "key: #{key}"
  puts "value: #{value}"
end

family.each do |test|
  puts "test: #{test}"
end
