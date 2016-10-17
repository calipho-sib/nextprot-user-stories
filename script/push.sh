#!/usr/bin/env bash

function echoUsage() {
    echo "usage: $(basename $0) [-h] <comment>" >&2
    echo "This script pushes your modifications to github."
    echo "Params:"
    echo " <comment> required message that comment your change(s)"
    echo "Options:"
    echo " -h print usage"
    echo " -a add all files to be pushed"
}

ADD_ALL=

while getopts 'ha' OPTION
do
    case ${OPTION} in
    h) echoUsage
        exit 0
        ;;
    a) echoUsage
        ADD_ALL=1
        ;;
    ?) echoUsage
        exit 1
        ;;
    esac
done

shift $(($OPTIND - 1))

args=("$*")

if [ $# -lt 1 ]; then
  echo "missing argument: You need to specify a message for the current push"  >&2
  echoUsage; exit 1
fi

MESSAGE=$1

git checkout develop

if [ ${ADD_ALL} ]; then
    echo -e "adding all file to commit..."
    git commit -a -m "${MESSAGE}"
else
    git commit -m "${MESSAGE}"
fi

git push origin develop

