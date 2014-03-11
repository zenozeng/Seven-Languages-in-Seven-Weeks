# -*- coding: utf-8 -*-
# 这里的代码利用了 method_missing
# 对于以下 csv
# one, two
# lions, tigers
# 有， csv = RubyCsv.new
# csv.each {|row| puts row.one}

class CsvRow
  
  def initialize(headers, row)
    @headers = headers
    @row = row
  end

  def method_missing name, *args

    # puts name.class => Symbol
    # puts args.class => Array

    # don't forget to convert to string
    index = @headers.index(name.to_s)

    # puts "Method_missing: #{name}"
    # puts "Headers: #{@headers}"
    # puts "Index: `#{index}`"

    if index
      @row[index]
    else
      nil
    end
  end

end

class RubyCsv

  def initialize(filename)
    read filename
  end

  def read(filename)
    file = File.new(filename)

    # chomp 可以去除末尾的换行符
    # gets 的副作用会 shift 掉首行
    @headers = file.gets.chomp.split(', ')
    @result = []

    file.each do |row|
      # << 是 Array 的 append
      # [ 1, 2 ] << "c" << "d" << [ 3, 4 ]
      #=>  [ 1, 2, "c", "d", [ 3, 4 ] ]
      @result << row.chomp.split(', ')
    end
  end

  def each(&block)
    @result.each do |row|
      block.call CsvRow.new(@headers, row)
    end
  end

end

csv = RubyCsv.new "sample.csv"
csv.each do |row|
  puts row.one
end
