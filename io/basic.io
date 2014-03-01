# http://iolanguage.org/

# 1 + 1 ==> 2
# 1 + "one" ==> Error
# (0) or true ==> true


# operator	 action
# ::=	 Creates slot, creates setter, assigns value
# :=	 Creates slot, assigns value
# =	 Assigns value to slot if it exists, otherwise raises exception


a := 2  // Must define slot using := operator before updating.
a = 3

Obj := Object clone
Obj test := method(n,
        n println
)
Obj test(42)