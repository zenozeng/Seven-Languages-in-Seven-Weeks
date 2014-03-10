# -*- coding: utf-8 -*-
# 这里的代码利用了 method_missing
# 对于以下 csv
# one, two
# lions, tigers
# 有， csv = RubyCsv.new
# csv.each {|row| puts row.one}

class CsvRow
  
  def initialize(headers, contents)
    # TODO
  end

  def self.method_missing name, *args
    name = name.to_s
    # TODO
  end

end

class RubyCsv

  attr_accessor :headers

  def initialize(filename)
    file = File.new(filename)
    @headers = file.gets.chomp.split(', ')

    file.each do |row|
      @result << row.chomp.split(', ')
    end
  end

  def each
    # TODO
  end

end

csv = RubyCsv.new "sample.csv"
csv.each do |row|
  puts row.one
end
