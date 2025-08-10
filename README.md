# ASCII Art

Loading images, translating them into ASCII art images, optionally apply filters, and save them.

## Filters

Supported image filters.

### Brightness

Changes the greyscale value of the pixel without losing precision.
Argument **--brightness value** where value is integer number. If a pixel brightness gets:

- below 0, then brightness must be 0.
- above 255, then brightness must be 255.

### Flip

Flips the image on **x** and **y** axis.
Argument **--flip x** or **--flip y**.

### Invert

Inverts greyscale pixel value. Inversion is done as follows: `255 - greyscale value`.
Argument ``-invert`.

### Rotate

Rotates the ASCII image.
Argument `--rotate degree`. Degree must be number divisiable by 90.

### Scale

Scales ASCII image.
Argument `--scale value`. Value can be: 0.25, 1, 4.

## Loading(importing)

Image can be loaded from file.
Supported file extensions:

- PNG.
- JPG.

Randomly generated RGB Image. Image will have dimensions from 70 to 200.

Arguments:

- `--image path` loads file from provided path.
- `--image random` generated random image.

## Saving(exporting)

ASCII image is printed in console by default, and can be exported to text file.
Arguments:

- `--output-console` prints ASCII image to console.
- `--output-file path` saves the image in provided text file.

## ASCII conversion

Supports:

- Paul Bourkle table. Default table.
- Custom table provided by the user.
- Non-linear table. Randomly generated.

Arguments:

- `table name` name parameter can be default or non-linear.
- `custom-table table` table parameter is characters provided by the user as a string.

## Input examples

After running `sbt` command:

```
run -image "assets/image.png"
```

```
run -image "assets/image.png" --flip x --rotate 90 --invert --scale 0.25 --flip y
```
