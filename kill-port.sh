#!/bin/bash
if [ "$1" ]
  then
      processIds=$(netstat -a -n -b -o | grep $1 | sed -e "s/[[:space:]]\+/ /g" | cut -d ' ' -f6)
      if [[ "$processIds" == "" ]]; then
        processIds=$(netstat -a -n -o | grep :8080 | awk '{print $NF}')
      fi
    echo "Attempting to kill processes running on port number $1"
    for processId in $processIds; do
      { #try 
          echo "Attempting to kill process with id of '$processId' running on port number '$1' using CYGWIN syntax"
            taskkill //F //PID "$processId"
          echo "Process on $1 killed."
      } || { # catch
          echo "Attempting to kill process with id of '$processId' running on port number '$1' using BASH syntax"
            taskkill /F /PID "$processId" 
          echo "Process on $1 killed."
      } || {
          echo "Process on $1 NOT killed."
      }
    done 
fi