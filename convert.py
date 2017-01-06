#!/usr/bin/env python
# -*- coding: utf-8 -*-

import time

with open("board.cfg") as f:
	for line in f:
		first = line.find('"name":')+len('"name":')+1
		secound = line.find('"', first)
		print line[first:secound]
time.sleep(50000)