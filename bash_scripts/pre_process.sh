#!/bin/bash
infile=$1
outfile=$2

awk -F "," 'BEGIN{
      id=0;
    }
    {
        if($6==11 && $7==11){
            id=id+1;
            print $1","$2","$3","$4","$5","$6","$7","$8","$9","$10","$11
            if(id==10000){
                exit
            }
        }
    }' $infile > $outfile
