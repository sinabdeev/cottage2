package domain;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class Printer {
	
	void print() {
		try {
			int
				width  = 1400,
				height = 1400;

			BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			Graphics2D graphics = image.createGraphics();
			graphics.setPaint(Color.white);
			graphics.fillRect(0, 0, width, height);
			printHouse(graphics);
			ImageIO.write(image, "PNG", new File("d:\\Fazenda\\yourImageName.PNG"));
			ImageIO.write(image, "GIF", new File("d:\\Fazenda\\yourImageName.GIF"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	void printHouse(Graphics2D graphics) {
		printOuterWalls(graphics);
	}
	

	void printOuterWalls(Graphics2D graphics) {
		graphics.setPaint(Color.ORANGE);
		
		int roomCorner = 55; // отступ от края листа
		int brickLength = 25; // длина кирпича
		int corridorXX = 200; // сторона корридора вдоль оси X
		int roomYY = 480; // сторона команты вдоль оси Y
		int kitchenXX = 480; // сторона кухни вдоль оси X
		int bathXX = 400; // сторона ванны вдоль оси X

		int zalXX = 480; // сторона зала вдоль оси X /
		int zalYY = 700; // сторона зала вдоль оси Y /

		int length = zalXX + brickLength + corridorXX + brickLength + kitchenXX;
		System.out.println("house xx = " + length);

		int roomXX = (length - 2 * brickLength - bathXX) / 2;

		System.out.println("room XX = " + roomXX);

		int houseYY = zalYY + brickLength + roomYY;
		int brickWidth = 12;
		int outerWallThickness = brickLength + 1 + brickWidth;

		// Север внешняя стена
		graphics.fillRect(roomCorner, roomCorner, outerWallThickness + length + outerWallThickness, outerWallThickness);

		// Запад внешняя стена
		graphics.fillRect(roomCorner, roomCorner, outerWallThickness, outerWallThickness + houseYY + outerWallThickness);

		int penX = roomCorner + outerWallThickness + length;
		int penY = roomCorner;

		// Восток внешняя стена
		graphics.fillRect(penX, penY, outerWallThickness, outerWallThickness + houseYY + outerWallThickness);

		penX = roomCorner;
		penY = roomCorner + outerWallThickness + houseYY;

		// Юг внешняя стена
		graphics.fillRect(penX, penY, outerWallThickness + length + outerWallThickness, outerWallThickness);


		// несущая стена вдоль оси X
		graphics.fillRect(roomCorner, roomCorner+outerWallThickness+roomYY, outerWallThickness + length + outerWallThickness, brickLength);

		// несущая стена вдоль оси Y
		graphics.fillRect(roomCorner+outerWallThickness+zalXX, roomCorner+outerWallThickness+roomYY+brickLength,
									brickLength, zalYY);

		// несущая стена вдоль оси Y
		graphics.fillRect(roomCorner+outerWallThickness+zalXX+brickLength+corridorXX, roomCorner+outerWallThickness+roomYY+brickLength,
				brickLength, zalYY);

		// перегородка вдоль оси Y
		graphics.fillRect(roomCorner+outerWallThickness+roomXX, roomCorner+outerWallThickness,
				brickLength, roomYY);




	}

	
	
	
}
