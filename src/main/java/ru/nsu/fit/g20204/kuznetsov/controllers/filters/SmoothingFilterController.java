package ru.nsu.fit.g20204.kuznetsov.controllers.filters;

import ru.nsu.fit.g20204.kuznetsov.History;
import ru.nsu.fit.g20204.kuznetsov.ui.content.DrawingArea;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SmoothingFilterController extends BaseFilterController {

    static int n = 5;
    static double sigma = 8;

    /**
     * Функция считает матрицу Гаусса
     * @param n размерность матрицы
     * @param sigma параметр Гаусса
     * @return матрицу Гаусса
     */
    public static double[][] getGaussMatrix(int n, double sigma) {
        double sum = 0.0;
        double[][] matrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Math.exp(-(Math.pow(i, 2) + Math.pow(j, 2)) / (2 * sigma));
                sum += matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] /= sum;
            }
        }
        return matrix;
    }

    /**
     * Фунция вычисления итого цвета по фильру
     *
     * @param imageBoarder Изображение с добавленными границами
     * @param matrixFilter Матрица фильра
     * @param x координата изначального изображения
     * @param y координата изначального изображения
     * @return целевой цвет для данной координаты
     */
    public static int getValueFilter(BufferedImage imageBoarder, double[][] matrixFilter, int x, int y) {
        int startX = x , startY = y ;
        double resultRed = 0;
        double resultBlue = 0;
        double resultGreen = 0;
        for (int i = 0; i < matrixFilter.length; i++) {
            for (int j = 0; j < matrixFilter.length; j++) {
                int rgb = imageBoarder.getRGB(startX + i, startY + j);

                int red = (rgb >> 16) & 0xff;
                resultRed += red * matrixFilter[i][j];

                int blue = rgb & 0xff;
                resultBlue += blue * matrixFilter[i][j];

                int green = (rgb >> 8) & 0xff;
                resultGreen += green * matrixFilter[i][j];

            }
        }
        return (0xff << 24) | ((int) (resultRed) << 16) | ((int) (resultGreen) << 8) | (int) (resultBlue);
    }

    /**
     * Функция добавляет симметричную границу
     *
     * @param image Исходное изображение
     * @param n     Ширина границы
     * @return Изображение с границами
     */
    public static BufferedImage addBoarderImage(BufferedImage image, int n) {
        BufferedImage newImage = new BufferedImage(image.getWidth() + 2 * n, image.getHeight() + 2 * n, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = newImage.createGraphics();

        g2d.drawImage(image, n, n, image.getWidth(), image.getHeight(), null);

        g2d.dispose();
        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < n; j++) {
                newImage.setRGB(i + n, j, image.getRGB(i, n - j));
            }
            for (int j = 1; j <= n; j++) {
                newImage.setRGB(i + n, newImage.getHeight() - j, image.getRGB(i, image.getHeight() - n + j - 1));
            }
        }
        for (int i = 0; i < newImage.getHeight(); i++) {
            for (int j = 0; j < n; j++) {
                newImage.setRGB(j, i, newImage.getRGB(2 * n - j, i));
            }
            for (int j = 0; j < n; j++) {
                newImage.setRGB(newImage.getWidth() - j - 1, i, newImage.getRGB(image.getWidth() + j, i));
            }
        }

        return newImage;
    }


    public static void performImage(Graphics g) {
        BufferedImage currentImage = History.getLastScreen();

        double[][] matrix_filter = getGaussMatrix(n, sigma);
        BufferedImage imageB = addBoarderImage(currentImage, n/2);

        for (int i = 0; i < currentImage.getWidth(); i++) {
            for (int j = 0; j < currentImage.getHeight(); j++) {
                currentImage.setRGB(i, j, getValueFilter(imageB, matrix_filter, i, j));
            }
        }
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(currentImage, 0, 0, History.getMaxWidth(), History.getMaxHeight(), java.awt.Color.WHITE, DrawingArea.getInstance());
    }
}
