import os
import json

# Set the input and output directories
input_dir = "assets/op-tools/models"
output_dir = "assets/op-tools/items"

# Create output directory if it doesn't exist
if not os.path.exists(output_dir):
    os.makedirs(output_dir)

# Subdirectories to process
subdirs = ["block", "item"]

# Process each subdirectory
for subdir in subdirs:
    # Construct full path to subdirectory
    full_path = os.path.join(input_dir, subdir)
    
    # Check if subdirectory exists
    if os.path.exists(full_path):
        # Iterate through all files in the subdirectory
        for filename in os.listdir(full_path):
            # Get the file name without extension
            name_without_ext = os.path.splitext(filename)[0]
            
            # Create the JSON content
            json_data = {
                "model": {
                    "type": "minecraft:model",
                    "model": f"op-tools:{subdir}/{name_without_ext}"
                }
            }
            
            # Create output filename (same name but with .json extension)
            output_filename = f"{name_without_ext}.json"
            output_path = os.path.join(output_dir, output_filename)
            
            # Write JSON to file
            with open(output_path, 'w') as json_file:
                json.dump(json_data, json_file, indent=2)
            
            print(f"Created: {output_path}")
    else:
        print(f"Warning: Directory not found: {full_path}")

print("Processing complete!")