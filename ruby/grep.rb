#!/usr/bin/env ruby
# -*- coding: utf-8 -*-

# 打印文件中出现某词组的行及行号
# Usage: ./grep.rb filename word1 word2 word3

# Notes:
# http://stackoverflow.com/questions/7157207/how-can-i-read-a-file-with-ruby

puts "ARGV: #{ARGV}"

filename = ARGV[0]

ARGV.shift
words = ARGV

if File.exist? filename
  File.open(filename, "r") do |content|
    line_number = 0
    while (line = content.gets)
      line_number += 1
      found = true
      for word in words
        unless line.index word
          found = nil
        end
      end
      if found
        puts "Line: #{line_number} : #{line}"
      end
    end
  end
else
  puts "File Not Found"
end


