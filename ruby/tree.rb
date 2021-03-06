# -*- coding: utf-8 -*-

class Tree

  # http://stackoverflow.com/questions/4370960/what-is-attr-accessor-in-ruby
  attr_accessor :children, :node_name

  def initialize(tree_obj)
    @children = []
    tree_obj.each do |node_name, children|
      @node_name = node_name
      if children
        children.each do |key, value|
          @children.push Tree.new(key => value)
        end
      end
    end
  end

  def visit_all(&block)
    visit &block
    children.each {|c| c.visit_all &block}
  end

  def visit(&block)
    block.call self
  end
end

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

family = Tree.new family

family.visit_all do |node|
  puts "Node Name: #{node.node_name}"
  puts "Children:"
  puts node.children
end
