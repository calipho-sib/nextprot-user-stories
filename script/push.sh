#!/usr/bin/env bash

function echoUsage() {
    echo "usage: $(basename $0) [-h] <comment>" >&2
    echo "This script pushes your modifications to github."
    echo "Params:"
    echo " <comment> required message that comment your change(s)"
    echo "Options:"
    echo " -h print usage"
}

while getopts 'h' OPTION
do
    case ${OPTION} in
    h) echoUsage
        exit 0
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
git commit -m "${MESSAGE}"
git push origin develop

