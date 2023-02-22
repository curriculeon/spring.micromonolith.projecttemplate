#!/bin/bash
find . -type f -name "*" -print0 | while read -d $'\0' file
do
  if [[ -f "$file" ]]; then
    sed -i "s/curriculeon/$1/g" "$file"
  fi
done
