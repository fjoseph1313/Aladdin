package aladdin.com.reports;

import static net.sf.dynamicreports.report.builder.DynamicReports.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import aladdin.com.model.Cart;
import net.sf.dynamicreports.report.builder.column.TextColumnBuilder;
import net.sf.dynamicreports.report.builder.group.ColumnGroupBuilder;
import net.sf.dynamicreports.report.builder.style.FontBuilder;
import net.sf.dynamicreports.report.constant.GroupHeaderLayout;
import net.sf.dynamicreports.report.constant.Orientation;
import net.sf.dynamicreports.report.datasource.DRDataSource;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRDataSource;

public class SalesReport {

	private List<Cart> carts;
	private String filename;

	public SalesReport(List<Cart> carts, String filename) {
		this.carts = carts;
		this.filename = filename;

	}

	public void build() throws IOException {
		FontBuilder boldFont = stl.fontArialBold().setFontSize(12);

		TextColumnBuilder<String> productCategoryCol = col.column("Category",
				"productCategory", type.stringType());

		ColumnGroupBuilder productCatGroup = grp.group(productCategoryCol)
				.setTitleWidth(70)
				.setHeaderLayout(GroupHeaderLayout.TITLE_AND_VALUE);

		TextColumnBuilder<String> productNameCol = col.column("Name",
				"productName", type.stringType()).setWidth(30);

		TextColumnBuilder<String> productDescriptionCol = col.column(
				"Description", "productDescription", type.stringType())
				.setWidth(50);

		TextColumnBuilder<Integer> quantityBoughtCol = col.column("Quantity",
				"quantityBought", type.integerType()).setWidth(20);

		try {
			FileOutputStream filePath;
			report().setTemplate(Templates.reportTemplate)
					.columns(productCategoryCol, productNameCol,
							productDescriptionCol, quantityBoughtCol)
					.groupBy(productCatGroup)
					.subtotalsAtFirstGroupFooter(sbt.sum(quantityBoughtCol))
					.subtotalsAtSummary(sbt.text("Total", productCategoryCol),
							sbt.sum(quantityBoughtCol))
					.title(Templates.createTitleComponent("Sales Report"))
					.summary(
							cht.pieChart().setTitle("Sales Chart")
									.setTitleFont(boldFont)
									.setKey(productCategoryCol)
									.setOrientation(Orientation.HORIZONTAL)
									.series(cht.serie(quantityBoughtCol)))
					.pageFooter(Templates.footerComponent)
					.setDataSource(createDataSource())
					.toPdf(filePath = new FileOutputStream(
							Templates.TEMP_STORAGE + filename + ".pdf"));

			filePath.close();
		} catch (DRException e) {

			e.printStackTrace();

		}
	}

	private JRDataSource createDataSource() {

		DRDataSource dataSource = new DRDataSource("productCategory",
				"productName", "productDescription", "quantityBought");

		for (Cart c : carts) {
			if (c.getOrder() != null) {
				dataSource.add(c.getProduct().getProductCategory()
						.getCategoryDescription(), c.getProduct()
						.getProductName(), c.getProduct()
						.getProductDescription(), c.getQuantity());
			}
		}

		return dataSource;

	}

}
