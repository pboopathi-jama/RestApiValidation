#!/usr/bin/env bash
if [ "$1" == "" ]; then
    echo "Please provide the yaml file you would like to process, as the first parameter."
    exit 1
else
        if [ "$2" == "" ]; then
            echo "Please provide the output json file you would like to create, as the second parameter."
            exit 1
        fi
fi

openapi2schema -i "$1" -p > compiledSchema.json
cat compiledSchema.json | sed -e 's/\"properties\"/\"additionalProperties\": false,\'$'\n\"properties\"/g' > dap.json
sed -i '' -e '2,5d' dap.json
cat dap.json | tail -r | tail -n +5 | tail -r > finalSchema.json

cat finalSchema.json | sed '/^.*format.*,$/d' | tr -d '\r\n' | sed -E 's/(,[[:space:]]+\"format\".[[:space:]]\"[a-zA-Z]+\")([[:space:]]+})/\2/g' | sed -e 's/  */ /g' > "$2"

rm compiledSchema.json
rm dap.json
rm finalSchema.json